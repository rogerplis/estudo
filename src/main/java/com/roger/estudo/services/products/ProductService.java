package com.roger.estudo.services.products;

import com.roger.estudo.Dtos.ProductRequestDto;
import com.roger.estudo.Dtos.ProductUpdateDto;
import com.roger.estudo.model.products.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(ProductRequestDto productDto);
    Product update(ProductUpdateDto productdto, Long id);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product>findByNameOrSku(String name, String sku);
    Optional<Product>  findByName(String name);
    Optional<Product> findBySku(String sku);
    Boolean existsByName(String name);
    Boolean existsBySku(String sku);
    void delete(Long id);

}
