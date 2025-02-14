package com.roger.estudo.repositories.products;

import com.roger.estudo.model.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    Optional<Product> findBySku(String sku);

    Boolean existsByName(String name);

    Boolean existsBySku(String sku);


}
