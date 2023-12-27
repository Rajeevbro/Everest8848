package com.everest8848.Everest8848.entity;

import com.everest8848.Everest8848.enums.PaymentMethod;
import com.everest8848.Everest8848.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private Date date;
    private Enum<PaymentStatus> paymentStatus;
    private Long amount;
    private Enum<PaymentMethod> paymentMethod;

}
