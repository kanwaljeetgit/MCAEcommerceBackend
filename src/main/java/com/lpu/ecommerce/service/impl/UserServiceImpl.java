package com.lpu.ecommerce.service.impl;

import com.lpu.ecommerce.exception.DataAlreadyExists;
import com.lpu.ecommerce.exception.RecordNotFound;
import com.lpu.ecommerce.model.User;
import com.lpu.ecommerce.repository.UserRepository;
import com.lpu.ecommerce.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author KANWALJEET on 28-11-2023
 * @project ecommerce
 **/

@Service
public class UserServiceImpl extends AbstractCommonService<User> implements UserService {

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder) {
        super(repo);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> getUserByUserName(String userName) throws RecordNotFound {
        return ((UserRepository)repo).findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByUserName(username).orElseThrow( () -> new RecordNotFound("user not found"));
    }

    @Override
    public User save(User user) {
        Optional<User> dbUser = getUserByUserName(user.getUsername());
        if(dbUser.isPresent()){
            throw new DataAlreadyExists("Data Already exists",dbUser.get());
        }
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return super.save(user);
    }
}
