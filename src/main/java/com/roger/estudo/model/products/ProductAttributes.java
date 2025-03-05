package com.roger.estudo.model.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_product_attributes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String value;
    private String unit;

    @JsonIgnore
    @ManyToOne
    private Product product;

    @JsonIgnore
    @ManyToOne
    private ProductVariation productVariation;


}
