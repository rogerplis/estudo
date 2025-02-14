package com.roger.estudo.services.products;

import com.roger.estudo.model.products.ProductImages;

import java.util.List;
import java.util.Set;

public interface ProductImagesService {

    ProductImages save(ProductImages productImages);
    List<?> saveAll(Set<ProductImages> productImages);
    ProductImages update(ProductImages productImages);

    ProductImages findById(Long id);

    void delete(Long id);

    void deleteAll();

    Iterable<ProductImages> findAll();
}
