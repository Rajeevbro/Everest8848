package com.everest8848.Everest8848.entity;

import jakarta.persistence.*;

import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true)
    @NotEmpty(message ="cannot be empty")
    private String name;

    @NotEmpty(message = "description cannot be empty")
    private String description;

    private String imgLink=" NOT_AVAILABLE";


    private Integer quantity =0;

    @Min(value = 0)
    private Long price;


}
