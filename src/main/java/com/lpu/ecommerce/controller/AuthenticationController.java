package com.lpu.ecommerce.controller;

import com.lpu.ecommerce.model.request.AuthenticationRequest;
import com.lpu.ecommerce.model.request.RegisterRequest;
import com.lpu.ecommerce.model.response.AuthenticationResponse;
import com.lpu.ecommerce.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author KANWALJEET on 01-12-2023
 * @project ecommerce
 **/

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
