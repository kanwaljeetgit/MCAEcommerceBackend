package com.lpu.ecommerce.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lpu.ecommerce.model.Cart;
import com.lpu.ecommerce.repository.CartRepository;
import com.lpu.ecommerce.service.impl.AbstractCommonService;
import com.lpu.ecommerce.utils.JsonUtils;
import org.hibernate.grammars.hql.HqlParser;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author KANWALJEET on 31-01-2024
 * @project ecommerce
 **/
class CartServiceTest {

    @Test
    void save() throws JsonProcessingException {
    }

    @Test
    void findByUser() {
    }
}