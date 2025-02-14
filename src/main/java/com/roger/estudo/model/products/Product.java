package com.roger.estudo.model.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_products")
@Data
@Builder
@AllArgsConstructor
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
    private Double netWeight;
    private Double grossWeight;
    private String weightUnit;
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
    private List<Category> category = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<ProductImages> images = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private  List<ProductVariation> variations = new ArrayList<>();

    @OneToMany
    private List<ProductAttributes> attributes = new ArrayList<>();

    @OneToMany
    private List<ProductRegulamentions> regulamentions = new ArrayList<>();

    public Product() {

    }
}
