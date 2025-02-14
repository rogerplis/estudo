package com.roger.estudo.model.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tb_product_variation")
@Data
public class ProductVariation {
    @Id
    private Long id;
    private String sku;
    private String color;
    private String size;
    private String gender;
    private String status;

    @JsonIgnore
    @ManyToOne
    private  Product product;

    @OneToMany
    private Set<ProductAttributes> attributes;

}
