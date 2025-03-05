package com.roger.estudo.services.products;

import com.roger.estudo.Dtos.ProductImagemDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductImages;

import java.util.List;

public interface ProductImagesService {

    ProductImages save(ProductImages productImages);
    void saveAll(List<ProductImagemDto> productImagemDtos, Product product);
    ProductImages update(ProductImages productImages);

    ProductImages findById(Long id);

    void delete(Long id);

    void deleteAll();

    Iterable<ProductImages> findAll();
}
