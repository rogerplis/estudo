package com.roger.estudo.controllers.products;

import com.roger.estudo.Dtos.ProductImagemDto;
import com.roger.estudo.Dtos.ProductRequestDto;
import com.roger.estudo.Dtos.ProductResponseDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductImages;
import com.roger.estudo.services.products.ProductImagesService;
import com.roger.estudo.services.products.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



@RestController
@RequestMapping("api/v1/products")
@Log4j2
public class ProductController {

    private final ProductService productService;

    private final ProductImagesService productImagesService;

    public ProductController(ProductService productService, ProductImagesService productImagesService) {
        this.productService = productService;
        this.productImagesService = productImagesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<?>> findAll() {
        if(productService.findAll().isEmpty()) return ResponseEntity.noContent().build();

        List<Product> products = productService.findAll();

        List<ProductResponseDto> productResponseDtos = products.stream()
                .map(product -> new ProductResponseDto(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getDescription(),
                        product.getSku(),
                        product.getBrand(),
                        product.getModel(),
                        product.getColor(),
                        product.getSize(),
                        product.getGender(),
                        product.getStatus(),
                        product.getType(),
                        product.getNetWeight(),
                        product.getGrossWeight(),
                        product.getWeightUnit(),
                        product.getLength(),
                        product.getWidth(),
                        product.getHeight(),
                        product.getVolume(),
                        product.getDate_create(),
                        product.getDate_update(),
                        product.getCategory(),
                        product.getImages().stream()
                                .map(img -> new ProductImagemDto(img.getAlt(), img.getUrl()))
                        .toList()
                )).toList();

        return ResponseEntity.ok(productService.findAll());}

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductRequestDto productDto) {
        if(productService.existsBySku(productDto.sku())) return ResponseEntity.badRequest().body("Product already exists");        Product product = productService.save(productDto);


        Set<ProductImages> images = productDto.images().stream().map(imgDto -> {
            ProductImages image = new ProductImages();
            image.setProduct(product);
            image.setUrl(imgDto.getUrl());
            image.setAlt(imgDto.getAlt());
            return image;
        }).collect(Collectors.toSet());

       // salva as imagens
        productImagesService.saveAll(images);


        return ResponseEntity.ok("Product saved");
    }

}
