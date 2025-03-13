package com.roger.estudo.controllers.products;

import com.roger.estudo.Dtos.ProductsAttributesDto;
import com.roger.estudo.model.products.ProductAttributes;
import com.roger.estudo.services.products.ProductAttributesService;
import com.roger.estudo.services.products.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/products/{id}/attributes")
public class ProductAttriutesController {

    private final ProductAttributesService service;
    private final ProductService productService;
    public ProductAttriutesController(ProductAttributesService service, ProductService productService) {
        this.service = service;
        this.productService = productService;
    }

    @PostMapping("/saveall")
    public ResponseEntity<?> salvarAttr(@PathVariable(value = "id") Long id, @RequestBody List<ProductsAttributesDto> attributes) {
        if(attributes.isEmpty()){return  ResponseEntity.badRequest().body("Attributes cannot be empty");}
        if(productService.findById(id).isEmpty()){
            return   ResponseEntity.badRequest().body("Product not found");
        }
        service.saveAll(attributes, productService.findById(id).get());
        return ResponseEntity.ok("Attributes saved");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deletarAttr(@RequestBody List<ProductAttributes> attributes) {
        List<Long> notFoundsId = new ArrayList<>();
        attributes.forEach(attr -> {
            if(service.existsById(attr.getId())){
                service.delete(attr.getId());
            }else {
                notFoundsId.add(attr.getId());
            }
        });
        if(!notFoundsId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Os seguintes ids nao foram encontrados: " +  notFoundsId);
        }else {
            return ResponseEntity.ok("Attributes deleted");
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> atualizarAttr(@RequestBody ProductAttributes attributes) {
        if(service.existsById(attributes.getId())){
            service.update(attributes);
            return ResponseEntity.ok("Attributes updated");
        }else {
            return ResponseEntity.badRequest().body("Attributes not found");
        }
    }
}
