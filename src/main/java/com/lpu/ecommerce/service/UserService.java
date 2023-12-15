package com.lpu.ecommerce.service;

import com.lpu.ecommerce.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

/**
 * @author KANWALJEET on 28-11-2023
 * @project ecommerce
 **/
public interface UserService extends CommonService<User>, UserDetailsService {

    Optional<User> getUserByUserName(String userName);

}
