package com.roger.estudo.services.products;

import com.roger.estudo.Dtos.ProductVariantesDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductVariation;

import java.util.List;

public interface ProductVariantService {

    ProductVariation save(ProductVariation productVariation);

    ProductVariation update(ProductVariation productVariation);

    void delete(Long id);

    ProductVariation findById(Long id);

    Iterable<ProductVariation> findAll();


    void saveAll(List<ProductVariantesDto> productVariations, Product product);

}
