package com.roger.estudo.services.products.impl;

import com.roger.estudo.Dtos.ProductsAttributesDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductAttributes;
import com.roger.estudo.repositories.products.ProductAttributesRepository;
import com.roger.estudo.services.products.ProductAttributesService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributesServiceImpl implements ProductAttributesService {

    private final ProductAttributesRepository repository;

    public ProductAttributesServiceImpl(ProductAttributesRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductAttributes save(ProductAttributes productAttributes) {
        return null;
    }

    @Override
    public void saveAll(List<ProductsAttributesDto> attributesDtos, Product product) {
        List<ProductAttributes> attributes = attributesDtos.stream().map(dto ->{
            ProductAttributes productAttributes1 = new ProductAttributes();
            BeanUtils.copyProperties(dto, productAttributes1);
            productAttributes1.setProduct(product);
            return productAttributes1;
            }).toList();

        repository.saveAll(attributes);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductAttributes findById(Long id) {
        return null;
    }

    @Override
    public ProductAttributes update(ProductAttributes productAttributes) {
        return null;
    }
}
