package com.roger.estudo.repositories.products;

import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductRegulamentions;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ProductRegulamentionsRepository extends JpaRepository<ProductRegulamentions, Long> {
    Optional<ProductRegulamentions> findByProduct(Product product);
}
