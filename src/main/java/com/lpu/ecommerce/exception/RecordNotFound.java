package com.lpu.ecommerce.exception;

/**
 * @author KANWALJEET on 29-11-2023
 * @project ecommerce
 **/
public class RecordNotFound extends RuntimeException {
    public RecordNotFound(String message) {
        super(message);
    }
}
