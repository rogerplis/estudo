package com.roger.estudo.model.products;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tb_products")
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String brand;
    private String sku;
    private String color;
    private String model;
    private String type;
    private String netWeight;
    private Double grossWeight;
    private Double weightUnit;
    private Double length;
    private Double width;
    private Double height;
    private Double volume;
    private String size;
    private String gender;
    private String status;
    private String date_update;
    private String date_create;

    // RELACIONAMENTOS
    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> category;

    @OneToMany(mappedBy = "product")
    private Set<ProductImages> images;

    @OneToMany(mappedBy = "product")
    private  Set<ProductVariation> variations;

    @OneToMany
    private Set<ProductAttributes> attributes;

    @OneToMany
    private Set<ProductRegulamentions> regulamentions;

    public Product() {

    }
}
