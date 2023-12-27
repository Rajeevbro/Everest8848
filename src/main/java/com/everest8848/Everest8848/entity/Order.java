package com.everest8848.Everest8848.entity;

import com.everest8848.Everest8848.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "payment_id",referencedColumnName = "paymentId")
    private Long paymentId;
    private Enum<OrderStatus>orderStatus;
    private Long productId;

}
