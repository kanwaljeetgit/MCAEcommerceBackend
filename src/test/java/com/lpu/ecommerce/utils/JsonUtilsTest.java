package com.lpu.ecommerce.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KANWALJEET on 31-01-2024
 * @project ecommerce
 **/
class JsonUtilsTest {

    @Test
    void getObjectMapperTest() {
        assertInstanceOf(ObjectMapper.class,JsonUtils.getObjectMapper(),"Not a ObjectMapper instance");
    }
}