package com.lpu.ecommerce.repository;

import com.lpu.ecommerce.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author KANWALJEET on 14-01-2024
 * @project ecommerce
 **/
@Repository
public interface OrderRepository extends CommonRepository<Order> {

    List<Order> findAllByStatus(Order.OrderStatus orderStatus);

}
