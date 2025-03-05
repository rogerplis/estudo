package com.roger.estudo.Dtos;

import java.util.List;

public record ProductRequestCompostoDto(
        String name,
        Double price,
        String description,
        String sku,
        String brand,
        String model,
        String color,
        String size,
        String gender,
        String status,
        String type,
        Double netWeight,
        Double grossWeight,
        String weightUnit,
        String measurementUnit,
        Double length,
        Double width,
        Double height,
        Double volume,
        List<Long> categoriesId,
        List<ProductImagemDto> images,
        List<ProductsAttributesDto> attributes,
        List<ProductVariantesDto> variations,
        List<ProductRegulamentionsDto> regulations,
        List<Long> components

) {

}
