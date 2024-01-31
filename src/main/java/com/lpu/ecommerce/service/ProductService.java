package com.lpu.ecommerce.service;

import com.lpu.ecommerce.exception.DataAlreadyExists;
import com.lpu.ecommerce.model.Product;
import com.lpu.ecommerce.model.Rating;
import com.lpu.ecommerce.repository.CommonRepository;
import com.lpu.ecommerce.repository.ProductRepository;
import com.lpu.ecommerce.service.impl.AbstractCommonService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author KANWALJEET on 19-12-2023
 * @project ecommerce
 **/

@Service
public class ProductService extends AbstractCommonService<Product> {
    public ProductService(ProductRepository repo) {
        super(repo);
    }

    @Override
    public Product save(Product product) {
        Optional<Product> productDB = ((ProductRepository) repo).findByTitle(product.getTitle());
        if(productDB.isPresent()){
            throw new DataAlreadyExists("Product Already exists",productDB.get());
        }
        Rating rating = product.getRating();
        if(rating == null){
            rating = Rating.builder().rate(0).count(0).build();
        }
        product.setRating(rating);
        return super.save(product);
    }



}
