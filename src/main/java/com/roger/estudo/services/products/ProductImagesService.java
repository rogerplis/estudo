package com.roger.estudo.services.products;

import com.roger.estudo.Dtos.ProductImagemDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductImages;

import java.util.List;
import java.util.Optional;

public interface ProductImagesService {

    ProductImages save(ProductImages productImages);


    void saveAll(List<ProductImagemDto> images, Product product);

    ProductImages update(ProductImages productImages);

    Optional<ProductImages> findById(Long id);

    void delete(Long id);

    void deleteAllImagesProduct(Long productId);

    Iterable<ProductImages> findAll();
}
