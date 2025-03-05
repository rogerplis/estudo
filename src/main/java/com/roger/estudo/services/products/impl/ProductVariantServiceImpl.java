package com.roger.estudo.services.products.impl;

import com.roger.estudo.Dtos.ProductVariantesDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductVariation;
import com.roger.estudo.repositories.products.ProductVariationRepository;
import com.roger.estudo.services.products.ProductVariantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductVariantServiceImpl implements ProductVariantService {


    private final ProductVariationRepository productVariationRepository;

    public ProductVariantServiceImpl(ProductVariationRepository productVariationRepository) {
        this.productVariationRepository = productVariationRepository;
    }

    @Override
    public ProductVariation save(ProductVariation productVariation) {
        return null;
    }

    @Override
    public ProductVariation update(ProductVariation productVariation) {
        productVariationRepository.save(productVariation);
        return null;
    }

    @Override
    public void delete(Long id) {
        productVariationRepository.deleteById(id);
    }

    @Override
    public ProductVariation findById(Long id) {
        return null;
    }

    @Override
    public Iterable<ProductVariation> findAll() {
        return null;
    }

    @Override
    public void saveAll(List<ProductVariantesDto> productVariationsDTO, Product product) {
        List<ProductVariation> productVariation =  productVariationsDTO.stream().map(dto -> {
            ProductVariation variation = new ProductVariation();
        BeanUtils.copyProperties(dto, variation);
        variation.setProduct(product);
        log.info(variation);
        return variation;

    }).toList();

        productVariationRepository.saveAll(productVariation);
    }

}
