package com.everest8848.Everest8848.entity;

import com.everest8848.Everest8848.enums.PaymentMethod;
import com.everest8848.Everest8848.enums.PaymentStatus;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    private Long paymentId;
    private Date date;
    private Enum<PaymentStatus> paymentStatus;
    private Long amount;
    private Enum<PaymentMethod> paymentMethod;

}
