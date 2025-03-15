package com.roger.estudo.services.products;

import com.roger.estudo.model.products.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category save(Category category);
    Category update(Category category);
    Category findById(Long id);
    void delete(Long id);

    Optional<Category> findByName(String name);

    List<Category> findAll();
}
