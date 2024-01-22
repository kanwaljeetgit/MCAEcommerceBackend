package com.lpu.ecommerce.service;

import com.lpu.ecommerce.exception.RecordNotFound;
import com.lpu.ecommerce.model.Order;
import com.lpu.ecommerce.repository.OrderRepository;
import com.lpu.ecommerce.service.impl.AbstractCommonService;
import com.lpu.ecommerce.utils.DateTimeUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author KANWALJEET on 14-01-2024
 * @project ecommerce
 **/
@Service
public class OrderService extends AbstractCommonService<Order> {
    public OrderService(OrderRepository repo) {
        super(repo);
    }

    @Override
    public Order save(Order order) {
        int size = order.getItems().size();
        AtomicReference<Double> tAmount = new AtomicReference<>(0d);
        AtomicReference<Double> tQuantity = new AtomicReference<>(0d);
        order.getItems().forEach(item-> {
            tQuantity.updateAndGet(v -> (v + item.getQuantity()));
            item.setAmount(item.getProduct().getPrice()*item.getQuantity());
            tAmount.updateAndGet(v -> (v + item.getAmount()));
            item.setOrder(order);
        });
        order.setTotalItemCount((double) size);
        order.setTotalAmount(tAmount.get());
        order.setTotalQuantity(tQuantity.get());
        return super.save(order);
    }

    public List<Order> getOrderForUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return repo.findByCreatedBy(userName);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteOrders() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        repo.deleteByCreatedBy(userName);
    }

    @Scheduled(fixedDelay = 60*60*1000)
    @Transactional(propagation = Propagation.REQUIRED)
    public void orderStatusBatchUpdate(){
        List<Order> allPendingOrder = ((OrderRepository) repo).findAllByStatus(Order.OrderStatus.PENDING);
        allPendingOrder.stream()
                .filter(ord-> DateTimeUtils.isDateTimeEqualOrBefore(ord.getCreatedTime().plusHours(2), LocalDateTime.now()))
                .forEach(order -> order.setStatus(Order.OrderStatus.ACCEPT));
        repo.saveAll(allPendingOrder);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Order orderStatusUpdate(Long orderId, Order.OrderStatus status){
        Order order = repo.findById(orderId).orElseThrow(()->new RecordNotFound("Order not found with order id : "+orderId));
        order.setStatus(status);
        return repo.save(order);
    }

}
