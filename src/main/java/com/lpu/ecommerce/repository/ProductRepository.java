package com.lpu.ecommerce.repository;

import com.lpu.ecommerce.model.Product;
import com.lpu.ecommerce.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author KANWALJEET on 19-12-2023
 * @project ecommerce
 **/

@Repository
public interface ProductRepository extends CommonRepository<Product>{
    @Query(value = "select * from product where title=?",nativeQuery = true)
    Optional<Product> findByTitle(String title);

    @Override
    @Transactional
    @Query(value = "SELECT p FROM Product p JOIN FETCH p.rating")
    List<Product> findAll();
}
