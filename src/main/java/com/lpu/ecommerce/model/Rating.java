package com.lpu.ecommerce.model;

import jakarta.persistence.Entity;
import lombok.*;

/**
 * @author KANWALJEET on 19-12-2023
 * @project ecommerce
 **/

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rating extends CommonEntityModel{
    private float rate;
    private Integer count;
}
