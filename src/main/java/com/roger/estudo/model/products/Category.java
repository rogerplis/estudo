package com.roger.estudo.model.products;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Product product;
}
