package com.lpu.ecommerce.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author KANWALJEET on 24-01-2024
 * @project ecommerce
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@Builder
public class ApiErrorResponse {

    private HttpStatus status;

    private final LocalDateTime timestamp = LocalDateTime.now();

    private String message;
}
