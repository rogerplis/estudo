package com.roger.estudo.services.products.impl;

import com.roger.estudo.model.products.Category;
import com.roger.estudo.repositories.products.CategoryRepository;
import com.roger.estudo.services.products.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public List<Category> findAll() {
        return List.of((Category) categoryRepository.findAll());
    }
}
