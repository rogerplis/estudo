package com.roger.estudo.Dtos;

import java.util.List;

public record ProductUpdateDto(
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
        String measurementUnit,
        Double length,
        Double width,
        Double height,
        Double volume

) {

}
