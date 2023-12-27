package com.everest8848.Everest8848.entity;

import com.everest8848.Everest8848.enums.Stars;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    @NotEmpty(message="Stars Cannot be empty")
    private Enum<Stars>star;
    private String comments;

@ManyToOne(targetEntity = Product.class,cascade = CascadeType.ALL)
@JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;


    private User user;

}
