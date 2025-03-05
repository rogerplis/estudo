package com.roger.estudo.repositories.products;

import com.roger.estudo.model.products.ProductVariation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariationRepository extends JpaRepository<ProductVariation, Long> {
}
