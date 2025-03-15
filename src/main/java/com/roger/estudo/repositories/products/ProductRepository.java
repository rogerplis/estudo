package com.roger.estudo.repositories.products;

import com.roger.estudo.model.products.Category;
import com.roger.estudo.model.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    Optional<Product> findBySku(String sku);

    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findBySkuContainingIgnoreCase(String sku);
    List<Product> findByNameContainingIgnoreCaseOrSkuContainingIgnoreCase(String name, String sku);
    List<Product> findByCategoryIn(Collection<List<Category>> category);



    Boolean existsByName(String name);

    Boolean existsBySku(String sku);


}
