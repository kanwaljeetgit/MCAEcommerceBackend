package com.lpu.ecommerce.exception;

import com.lpu.ecommerce.model.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author KANWALJEET on 24-01-2024
 * @project ecommerce
 **/

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ApiErrorResponse> onException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(ApiErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage()).build(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
