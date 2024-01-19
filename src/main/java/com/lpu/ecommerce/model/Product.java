package com.lpu.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class Product extends CommonEntityModel {

    @NotNull
    private String title;
    @NotNull
    @Pattern(regexp = "^[1-9]\\d*(\\.\\d{1,2})?$", message = "Invalid price format")
    private Float price;
    @NotNull
    @Column(columnDefinition="TEXT")
    private String description;
    @NotNull
    private String category;
    @NotNull
    private String image;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id")
    private Rating rating;
}
