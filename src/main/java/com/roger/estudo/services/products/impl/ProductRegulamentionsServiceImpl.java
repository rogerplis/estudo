package com.roger.estudo.services.products.impl;

import com.roger.estudo.Dtos.ProductRegulamentionsDto;
import com.roger.estudo.Dtos.ProductVariantesDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductRegulamentions;
import com.roger.estudo.model.products.ProductVariation;
import com.roger.estudo.repositories.products.ProductRegulamentionsRepository;
import com.roger.estudo.repositories.products.ProductVariationRepository;
import com.roger.estudo.services.products.ProductRegulamentionsService;
import com.roger.estudo.services.products.ProductVariantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductRegulamentionsServiceImpl implements ProductRegulamentionsService {


    private final ProductRegulamentionsRepository productRegulamentionsRepository;

    public ProductRegulamentionsServiceImpl(ProductRegulamentionsRepository productRegulamentionsRepository) {
        this.productRegulamentionsRepository = productRegulamentionsRepository;
    }




    @Override
    public ProductRegulamentions save(ProductRegulamentionsDto productRegulamentions, Product product) {
        return null;
    }

    @Override
    public ProductRegulamentions update(ProductRegulamentions productRegulamentions) {
        return null;
    }

    @Override
    public void saveAll(List<ProductRegulamentionsDto> productRegulamentionsDto, Product product) {
        List<ProductRegulamentions> ProductRegulamentions =  productRegulamentionsDto.stream().map(regulationDto -> {
            ProductRegulamentions regulamentions = new ProductRegulamentions();
            BeanUtils.copyProperties(regulationDto, regulamentions);
            regulamentions.setProduct(product);
            return regulamentions;
        }).toList();
        productRegulamentionsRepository.saveAll(ProductRegulamentions);


    }

    @Override
    public List<ProductRegulamentions> findByProduct(Product product) {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
