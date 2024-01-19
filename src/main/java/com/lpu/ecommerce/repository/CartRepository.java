package com.lpu.ecommerce.repository;

import com.lpu.ecommerce.model.Cart;
import com.lpu.ecommerce.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author KANWALJEET on 02-01-2024
 * @project ecommerce
 **/
public interface CartRepository extends CommonRepository<Cart> {

    @Query(value = "select * from cart where user=?",nativeQuery = true)
    Optional<Cart> findByUser(String user);

}
