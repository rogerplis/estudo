package com.roger.estudo.services.products;

import com.roger.estudo.Dtos.ProductRequestDto;
import com.roger.estudo.model.products.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(ProductRequestDto productDto);
    Product update(Product product);
    Product findById(Long id);
    List<Product> findAll();
    Optional<Product>  findByName(String name);
    Optional<Product> findBySku(String sku);
    Boolean existsByName(String name);
    Boolean existsBySku(String sku);
    void delete(Long id);

}
