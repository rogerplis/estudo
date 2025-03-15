package com.roger.estudo.repositories.products;

import com.roger.estudo.model.products.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {



    Optional<Category> findByName(String name);
}
