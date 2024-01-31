package com.lpu.ecommerce.config.filter;

import com.lpu.ecommerce.model.response.ApiErrorResponse;
import com.lpu.ecommerce.utils.JsonUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author KANWALJEET on 24-01-2024
 * @project ecommerce
 **/
@Component
public class AuthenticationPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json");
        ApiErrorResponse error = (ApiErrorResponse) request.getAttribute("api_error");
        if(error == null) {
            error = ApiErrorResponse.builder().status(HttpStatus.FORBIDDEN).message("Authorization Failed").build();
        }
        response.getOutputStream().println(JsonUtils.getObjectMapper().writeValueAsString(error));
    }
}