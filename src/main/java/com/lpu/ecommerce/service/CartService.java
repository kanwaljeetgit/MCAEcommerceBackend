package com.lpu.ecommerce.service;

import com.lpu.ecommerce.exception.RecordNotFound;
import com.lpu.ecommerce.model.Cart;
import com.lpu.ecommerce.repository.CartRepository;
import com.lpu.ecommerce.service.impl.AbstractCommonService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author KANWALJEET on 02-01-2024
 * @project ecommerce
 **/

@Service
public class CartService extends AbstractCommonService<Cart> {
    public CartService(CartRepository repo) {
        super(repo);
    }

    @Override
    public Cart save(Cart cart) {
        cart.setUser(cart.getUser()==null ? SecurityContextHolder.getContext().getAuthentication().getName() : cart.getUser());
        try {
            Cart cartFromDB = findByUser(cart.getUser());
            cartFromDB.setCartData(cart.getCartData());
            cart = cartFromDB;
        }catch (RecordNotFound ex){
            //nothing to do
        }
        return super.save(cart);
    }

    public Cart findByUser(String user){
        return ((CartRepository)repo).findByUser(user).orElseThrow(() -> new RecordNotFound("cart not found"));
    }

}
