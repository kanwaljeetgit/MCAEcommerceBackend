package com.lpu.ecommerce.service;

import com.lpu.ecommerce.model.Role;
import com.lpu.ecommerce.model.User;
import com.lpu.ecommerce.model.request.AuthenticationRequest;
import com.lpu.ecommerce.model.request.RegisterRequest;
import com.lpu.ecommerce.model.response.AuthenticationResponse;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author KANWALJEET on 01-12-2023
 * @project ecommerce
 **/
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    private final JwtService jwtService;

    private final AuthenticationManager authManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getEmail())
                .name(request.getFirstName() + " " + request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.isAdmin() ? Role.ADMIN : Role.USER)
                .build();
        var dbUser = userService.save(user);
        var token = jwtService.generateToken(dbUser);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userService.loadUserByUsername(request.getEmail());
        var token = jwtService.generateToken(user);
        Date date = jwtService.extractClaims(token, Claims::getExpiration);
        return AuthenticationResponse.builder()
                .token(token)
                .expireAt(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                .build();
    }
}
