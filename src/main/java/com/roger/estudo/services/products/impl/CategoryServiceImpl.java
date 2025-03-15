package com.roger.estudo.services.products.impl;

import com.roger.estudo.model.products.Category;
import com.roger.estudo.repositories.products.CategoryRepository;
import com.roger.estudo.services.products.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }


    @Override
    public List<Category> findAll() {
        return  categoryRepository.findAll();
    }
}
