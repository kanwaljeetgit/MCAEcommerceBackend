package com.lpu.ecommerce.exception;

import lombok.Data;

/**
 * @author KANWALJEET on 01-12-2023
 * @project ecommerce
 **/
@Data
public class DataAlreadyExists extends RuntimeException{

    private Object data;

    public DataAlreadyExists(String message) {
        super(message);
    }

    public DataAlreadyExists(String message,Object data) {
        super(message);
        this.data = data;
    }

}
