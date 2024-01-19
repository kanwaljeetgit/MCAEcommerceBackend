package com.lpu.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.lpu.ecommerce.converter.JSONObjectConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * @author KANWALJEET on 02-01-2024
 * @project ecommerce
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends CommonEntityModel{

    @Column(columnDefinition = "json")
    @Convert(converter = JSONObjectConverter.class)
    private JsonNode cartData;

    private String user;

}
