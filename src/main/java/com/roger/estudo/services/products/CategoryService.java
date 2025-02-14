package com.roger.estudo.services.products;

import com.roger.estudo.model.products.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);
    Category update(Category category);
    Category findById(Long id);
    void delete(Long id);
    List<Category> findAll();
}
