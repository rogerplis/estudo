package com.roger.estudo.model.products;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_product_images")
@Data
public class ProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String alt;

    @ManyToOne
    private Product product;
}
