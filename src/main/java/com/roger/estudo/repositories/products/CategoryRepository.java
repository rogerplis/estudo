package com.roger.estudo.repositories.products;

import com.roger.estudo.model.products.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
