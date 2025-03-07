package com.roger.estudo.model.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_product_regulamentions")
@Data
public class ProductRegulamentions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regulationName;
    private String regulationValue;

    @JsonIgnore
    @ManyToOne
    private Product product;

}
