package com.lpu.ecommerce.repository;


import com.lpu.ecommerce.model.CommonEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author KANWALJEET on 29-11-2023
 * @project ecommerce
 **/
@NoRepositoryBean
public interface CommonRepository<T extends CommonEntityModel> extends JpaRepository<T,Long> {
}
