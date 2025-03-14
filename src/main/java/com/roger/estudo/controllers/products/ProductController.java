package com.roger.estudo.controllers.products;

import com.roger.estudo.Dtos.*;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.services.products.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/products")
@Log4j2
public class ProductController {

    private final ProductService productService;

    private final ProductImagesService productImagesService;

    private final ProductAttributesService productAttributesService;

    private final ProductVariantService productVariantService;

    private final ProductRegulamentionsService productRegulamentionsService;



    public ProductController(ProductService productService, ProductImagesService productImagesService, ProductAttributesService productAttributesService, ProductVariantService productVariantService, ProductRegulamentionsService productRegulamentionsService) {
        this.productService = productService;
        this.productImagesService = productImagesService;
        this.productAttributesService = productAttributesService;
        this.productVariantService = productVariantService;
        this.productRegulamentionsService = productRegulamentionsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<?>> findAll(@RequestParam(required = false) String name, @RequestParam(required = false) String sku) {
        List<Product> products;

        if(name != null || sku != null) {
            products = productService.findByNameOrSku(name, sku);
        }else {
            products = productService.findAll();
        }
        if (products.isEmpty()) return ResponseEntity.noContent().build();

        List<ProductResponseDto> productResponseDtos = products.stream().map(product -> new ProductResponseDto(
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
                    product.getDate_update(),
                    product.getDate_create(),
                    product.getCategory(),
                    product.getImages().stream().map(image -> new ProductImagemDto(image.getUrl(), image.getAlt(), image.getPosition())).toList(),
                    product.getAttributes().stream().map(attribute -> new ProductsAttributesDto(attribute.getName(), attribute.getValue(), attribute.getUnit())).toList(),
                    product.getVariations().stream().map(variant -> new ProductVariantesDto(variant.getSku(), variant.getStatus(), variant.getAttributes().stream().map(attribute -> new ProductsAttributesDto(attribute.getName(), attribute.getValue(), attribute.getUnit())).toList())).toList()

            )).toList();

        return ResponseEntity.ok(productResponseDtos);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductRequestDto productDto) {
        // validaçoes iniciais
        if (productService.existsBySku(productDto.sku()))
            return ResponseEntity.badRequest().body("Product already exists");
        // recupera as imagens
        List<ProductImagemDto> images = productDto.images().stream().toList();
        if (images.isEmpty()) return ResponseEntity.badRequest().body("Product must have at least one image");
        // recupera os atributos do produto
        // alguns marketplaces tem atributos obrigatórios, eles serao passados via api de categorização
        List<ProductsAttributesDto> attributes = productDto.attributes().stream().toList();
        if (attributes.isEmpty()) return ResponseEntity.badRequest().body("Product must have at least one attribute");


        // Salva o producto principal
        Product product = productService.save(productDto);
        // salva as imagens do produto
        productImagesService.saveAll(images, product);

        // salva os atributos do produto
        productAttributesService.saveAll(attributes, product);

        // recupera as variaçoes
        List<ProductVariantesDto> variants = productDto.variations().stream().toList(); // ProductVariantesDTO>
       // só salva se tiver variacoes
        if (!variants.isEmpty()){
            // salva as variaçoes
            productVariantService.saveAll(variants, product);
        }
        // recupera a regulamentacao
        List<ProductRegulamentionsDto> regulamentions = productDto.regulations().stream().toList();
        // salva as regulamentacoes
        if(!regulamentions.isEmpty())
            productRegulamentionsService.saveAll(regulamentions, product);


        return ResponseEntity.ok("Product saved");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ProductUpdateDto productDto) {
        // validaçoes iniciais
        if (productService.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("Product not exist");
        productService.update(productDto,id);

        return ResponseEntity.ok("Product updated");
    }

    @GetMapping("/find/{sku}")
    public ResponseEntity<?> findBySku(@PathVariable(value = "sku")String sku){
        if(productService.findBySku(sku).isEmpty()) return ResponseEntity.badRequest().body("Product not exist");
        return ResponseEntity.ok(productService.findBySku(sku));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if (productService.findById(id).isEmpty()) return ResponseEntity.badRequest().body("Product not exist");
        productService.delete(id);
        return ResponseEntity.ok("Product deleted");

    }
}
