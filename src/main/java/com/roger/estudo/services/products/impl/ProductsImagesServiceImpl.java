package com.roger.estudo.services.products.impl;

import com.roger.estudo.Dtos.ProductImagemDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductImages;
import com.roger.estudo.repositories.products.ProductImageRepository;
import com.roger.estudo.services.products.ProductImagesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
            image.setPosition(img.position());
            return image;
        }).toList();

        repository.saveAll(productImages);
    }

    @Override
    public ProductImages update(ProductImages productImages) {
        return null;
    }

    @Override
    public Optional<ProductImages> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllImagesProduct(Long productId) {
        repository.deleteByProductId(productId);
    }

    @Override
    public Iterable<ProductImages> findAll() {
        return null;
    }
}
