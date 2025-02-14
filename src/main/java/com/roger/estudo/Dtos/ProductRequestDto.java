package com.roger.estudo.Dtos;

import java.util.Set;

public record ProductRequestDto(
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
        Set<Long> categoriesId
) {
}
