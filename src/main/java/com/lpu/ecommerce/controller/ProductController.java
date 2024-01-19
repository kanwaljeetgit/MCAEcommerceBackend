package com.lpu.ecommerce.controller;

import com.lpu.ecommerce.model.Product;
import com.lpu.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author KANWALJEET on 19-12-2023
 * @project ecommerce
 **/

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> saveProducts(@RequestBody @Valid Product product){
        Product saveProduct = productService.save(product);
        return ResponseEntity.ok(saveProduct);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Product>> saveProducts(@RequestBody @Valid List<Product> products){
        List<Product> saveProduct = productService.save(products);
        return ResponseEntity.ok(saveProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.findAll());
    }

}
