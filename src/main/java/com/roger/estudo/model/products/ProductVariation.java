package com.roger.estudo.model.products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_product_variation")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductVariation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String status;

    @JsonIgnore
    @ManyToOne
    private  Product product;

    @JsonIgnore
    @OneToMany
    private List<ProductAttributes> attributes;

}
