package com.roger.estudo.services.products;

import com.roger.estudo.Dtos.ProductsAttributesDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductAttributes;

import java.util.List;

public interface ProductAttributesService {

    ProductAttributes save(ProductAttributes productAttributes);
    void saveAll(List<ProductsAttributesDto> productAttributes, Product product);
    void delete(Long id);
    ProductAttributes findById(Long id);

    ProductAttributes update(ProductAttributes productAttributes);
}
