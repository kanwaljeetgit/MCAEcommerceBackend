package com.lpu.ecommerce.repository;

import com.lpu.ecommerce.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author KANWALJEET on 29-11-2023
 * @project ecommerce
 **/
@Repository
public interface UserRepository extends CommonRepository<User> {
    @Query(value = "select * from user where username=?",nativeQuery = true)
    Optional<User> findByUserName(String userName);
}
