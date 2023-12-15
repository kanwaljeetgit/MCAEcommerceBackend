package com.lpu.ecommerce.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KANWALJEET on 29-11-2023
 * @project ecommerce
 **/
class StringUtilsTest {

    @Test
    void format() {
        String formatted = StringUtils.format("Hi {}, How are you {}.", "Kanwaljeet", "?");
        System.out.println(formatted);
        assertEquals("Hi Kanwaljeet, How are you ?.",formatted);
    }

    @Test
    void stringUtilObjectCreationTest() {
        Class<StringUtils> stringUtilsClass = StringUtils.class;
        Constructor<?> declaredConstructor = stringUtilsClass.getDeclaredConstructors()[0];
        InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, () -> {
            declaredConstructor.setAccessible(true);
            declaredConstructor.newInstance();
        });
        assertEquals(IllegalAccessException.class,invocationTargetException.getCause().getClass());
        assertEquals("you can not create an object of utility class",invocationTargetException.getCause().getMessage());
    }

}