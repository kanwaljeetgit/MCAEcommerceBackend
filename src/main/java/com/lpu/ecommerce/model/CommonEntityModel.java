package com.lpu.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @project Ecommerce
 * @author KANWALJEET on 28-11-2023
**/
@Data
@MappedSuperclass
public class CommonEntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String createdBy;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;


}
