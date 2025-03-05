package com.roger.estudo.services.products;

import com.roger.estudo.Dtos.ProductRegulamentionsDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductRegulamentions;

import java.util.List;

public interface ProductRegulamentionsService {


    ProductRegulamentions save(ProductRegulamentionsDto productRegulamentions, Product product);
    ProductRegulamentions update(ProductRegulamentions productRegulamentions);
    // save all
    void saveAll(List<ProductRegulamentionsDto> productRegulamentions, Product product);
    // find by product
    List<ProductRegulamentions> findByProduct(Product product);
    void delete(Long id);
}
