package com.lpu.ecommerce.service.impl;

import com.lpu.ecommerce.exception.RecordNotFound;
import com.lpu.ecommerce.model.CommonEntityModel;
import com.lpu.ecommerce.repository.CommonRepository;
import com.lpu.ecommerce.service.CommonService;
import com.lpu.ecommerce.utils.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

/**
 * @author KANWALJEET on 28-11-2023
 * @project ecommerce
 **/

@AllArgsConstructor
public abstract class AbstractCommonService<T extends CommonEntityModel> implements CommonService<T> {

    protected CommonRepository<T> repo;

    @Override
    public T save(T t) {
        t.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        t.setCreatedTime(LocalDateTime.now());
        t.setUpdatedTime(t.getCreatedTime());
        return repo.save(t);
    }

    @Override
    public T getById(Long id) throws RecordNotFound {
        return repo.findById(id).orElseThrow(()->new RecordNotFound(StringUtils.format("No data present with id {}")));
    }

}
