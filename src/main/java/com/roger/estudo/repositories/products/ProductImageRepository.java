package com.roger.estudo.repositories.products;

import com.roger.estudo.model.products.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ProductImageRepository extends JpaRepository<ProductImages, Long> {
    Optional<ProductImages> findProductImagesByProductId(Long productId);
    void deleteByProductId(Long productId);



}
