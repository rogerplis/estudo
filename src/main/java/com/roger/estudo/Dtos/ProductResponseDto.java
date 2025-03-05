package com.roger.estudo.Dtos;

import com.roger.estudo.model.products.Category;

import java.util.List;

public record ProductResponseDto(
        Long id,
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
                                 Double length,
                                 Double width,
                                 Double height,
                                 Double volume,
                                 String date_update,
                                 String date_create,
                                 List<Category> categories,
                                 List<ProductImagemDto> images,
                                 List<ProductsAttributesDto> attributes,
                                 List<ProductVariantesDto> variations)

{

}
