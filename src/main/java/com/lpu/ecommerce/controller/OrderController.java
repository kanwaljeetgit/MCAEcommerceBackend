package com.lpu.ecommerce.controller;

import com.lpu.ecommerce.model.Order;
import com.lpu.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author KANWALJEET on 14-01-2024
 * @project ecommerce
 **/
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Validated
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
       return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<>(orderService.getOrderForUser(),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<List<Order>> deleteOrder(){
        orderService.deleteOrders();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
