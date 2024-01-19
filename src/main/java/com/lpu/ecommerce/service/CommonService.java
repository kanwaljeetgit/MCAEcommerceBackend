package com.lpu.ecommerce.service;

import com.lpu.ecommerce.exception.RecordNotFound;
import com.lpu.ecommerce.model.CommonEntityModel;
import com.lpu.ecommerce.model.Product;

import java.util.List;

/**
 * @author KANWALJEET on 28-11-2023
 * @project ecommerce
 **/
public interface CommonService<T extends CommonEntityModel> {

    T save(T t);

    T getById(Long id) throws RecordNotFound;

    List<T> findAll();

    List<T> save(List<T> t);
}
