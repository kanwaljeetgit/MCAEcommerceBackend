package com.lpu.ecommerce.service;

import com.lpu.ecommerce.exception.RecordNotFound;
import com.lpu.ecommerce.model.CommonEntityModel;

/**
 * @author KANWALJEET on 28-11-2023
 * @project ecommerce
 **/
public interface CommonService<T extends CommonEntityModel> {

    T save(T t);

    T getById(Long id) throws RecordNotFound;

}
