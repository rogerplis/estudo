package com.roger.estudo.services.products.impl;

import com.roger.estudo.Dtos.ProductRequestDto;
import com.roger.estudo.Dtos.ProductUpdateDto;
import com.roger.estudo.model.products.Category;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.repositories.products.CategoryRepository;
import com.roger.estudo.repositories.products.ProductRepository;
import com.roger.estudo.services.products.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private  final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Product save(ProductRequestDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);

        List<Category> categories = productDto.categoriesId().stream().map(id -> {
            Category category = new Category();
            category.setId(id);
            return category;
        }).collect(Collectors.toList());
        product.setDate_create(LocalDate.now().toString());

        product.setCategory(categories);
        return repository.save(product);
    }

    @Override
    public Product update(ProductUpdateDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return repository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return  repository.findAll();
    }

    @Override
    public  Optional<Product>  findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<Product> findBySku(String sku) {
        return repository.findBySku(sku);
    }

    @Override
    public Boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public Boolean existsBySku(String sku) {
        return repository.existsBySku(sku);
    }

    @Override
    public void delete(Long id) {

    }
}
