package com.roger.estudo.model.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.roger.estudo.Dtos.ProductRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

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
    private String measurementUnit;
    private Double length;
    private Double width;
    private Double height;
    private Double volume;
    private String size;
    private String gender;
    private String status;
    private String date_update;
    private String date_create;

    @ElementCollection
    @CollectionTable(name = "tb_product_component", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "product_component_id")
    private List<Long> component;

    // RELACIONAMENTOS
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> category = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImages> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private  List<ProductVariation> variations = new ArrayList<>();

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL )
    private List<ProductAttributes> attributes = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductRegulamentions> regulamentions = new ArrayList<>();

    public Product() {
    }

}
