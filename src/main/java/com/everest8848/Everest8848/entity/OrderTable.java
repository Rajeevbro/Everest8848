package com.everest8848.Everest8848.entity;

import com.everest8848.Everest8848.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Enum<OrderStatus> orderStatus;

    @OneToOne(targetEntity = Payment.class,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
    private Payment payment;



    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;


}
