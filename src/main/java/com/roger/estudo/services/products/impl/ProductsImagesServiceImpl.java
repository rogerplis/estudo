package com.roger.estudo.services.products.impl;

import com.roger.estudo.Dtos.ProductImagemDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductImages;
import com.roger.estudo.repositories.products.ProductImageRepository;
import com.roger.estudo.services.products.ProductImagesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductsImagesServiceImpl implements ProductImagesService {

    private final ProductImageRepository repository;


    public ProductsImagesServiceImpl(ProductImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductImages save(ProductImages productImages) {
        return null;
    }

    @Override
    public void saveAll(List<ProductImagemDto> images, Product product) {

        List<ProductImages> productImages = images.stream().map(img -> {
            ProductImages image = new ProductImages();
            image.setProduct(product);
            image.setUrl(img.url());
            image.setAlt(img.alt());
            return image;
        }).toList();

        repository.saveAll(productImages);
    }

    @Override
    public ProductImages update(ProductImages productImages) {
        return null;
    }

    @Override
    public ProductImages findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Iterable<ProductImages> findAll() {
        return null;
    }
}
