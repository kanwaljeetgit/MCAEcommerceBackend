package com.lpu.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
@Table(name = "Orders")
public class Order extends CommonEntityModel{

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItem> items;

    private Double totalAmount;

    private Double totalQuantity;

    private Double totalItemCount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    public enum OrderStatus{
        PENDING,ACCEPT,REJECTED
    }

    @Override
    public String toString() {
        return "Order{" +
                " orderId " + getId() +
                " totalAmount=" + totalAmount +
                ", totalQuantity=" + totalQuantity +
                ", totalItemCount=" + totalItemCount +
                '}';
    }
}
