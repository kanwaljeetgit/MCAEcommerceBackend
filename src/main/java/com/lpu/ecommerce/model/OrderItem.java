package com.lpu.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author KANWALJEET on 14-01-2024
 * @project ecommerce
 **/

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem extends CommonEntityModel{

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Double quantity;
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product.getDescription() +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
