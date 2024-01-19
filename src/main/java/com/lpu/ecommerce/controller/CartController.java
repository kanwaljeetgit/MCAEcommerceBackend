package com.lpu.ecommerce.controller;

import com.lpu.ecommerce.model.Cart;
import com.lpu.ecommerce.service.CartService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author KANWALJEET on 02-01-2024
 * @project ecommerce
 **/
@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@Validated
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> saveCart(@Valid @RequestBody Cart cart){
        Cart savedCart = cartService.save(cart);
        return ResponseEntity.ok(savedCart);
    }

    @GetMapping
    public ResponseEntity<Cart> getCart(){
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(cartService.findByUser(user));
    }

}
