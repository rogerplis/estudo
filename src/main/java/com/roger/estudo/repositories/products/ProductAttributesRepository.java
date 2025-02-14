package com.roger.estudo.repositories.products;

import com.roger.estudo.model.products.ProductAttributes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributesRepository extends JpaRepository<ProductAttributes, Long> {
}
