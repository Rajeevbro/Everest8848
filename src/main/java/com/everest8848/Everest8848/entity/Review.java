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

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name="product_id",referencedColumnName = "id")
    private Long productId;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Long userId;

}
