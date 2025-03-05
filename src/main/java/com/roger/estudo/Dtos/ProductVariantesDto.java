package com.roger.estudo.Dtos;

import java.util.List;

public record ProductVariantesDto(String sku, String status, List<ProductsAttributesDto> attributesList) {

}
