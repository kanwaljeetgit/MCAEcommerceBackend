package com.lpu.ecommerce.controller;

import com.lpu.ecommerce.exception.DataAlreadyExists;
import com.lpu.ecommerce.model.User;
import com.lpu.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KANWALJEET on 28-11-2023
 * @project ecommerce
 **/
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        try {
            return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
        }catch(DataAlreadyExists ex){
            return new ResponseEntity<>((User) ex.getData(), HttpStatus.OK);
        }
    }

}
