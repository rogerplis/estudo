package com.roger.estudo.controllers.products;

import com.roger.estudo.Dtos.ProductImagemDto;
import com.roger.estudo.model.products.Product;
import com.roger.estudo.model.products.ProductImages;
import com.roger.estudo.services.products.ProductImagesService;
import com.roger.estudo.services.products.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products/{id}/images")
public class ProductImagemController {
    
    private final ProductImagesService service;
    private final ProductService productService;
    public ProductImagemController(ProductImagesService service, ProductService productService) {
        this.service = service;
        this.productService = productService;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> adicionarImagens(@PathVariable(value = "id")Long id, @RequestBody List<ProductImagemDto> images ){
        if (images.isEmpty()) return ResponseEntity.badRequest().body("Imagens vazias");
        if (productService.findById(id).isEmpty()){
            return ResponseEntity.badRequest().body("Produto não encontrado");
        }
        Product product = productService.findById(id).get();
        
        service.saveAll(images,product);
        return ResponseEntity.ok("Imagens adicionadas com sucesso");
        
    }
    @DeleteMapping("delete")
    public ResponseEntity<?> deletarImagens(@RequestBody ProductImages images ){
        if (service.findById(images.getId()).isPresent()){
            service.delete(images.getId());
            return  ResponseEntity.ok("Imagens deletadas com sucesso");
        }
        return ResponseEntity.badRequest().body("Imagens não encontradas");
    }

    @DeleteMapping(value = "/delete/allforproduct")
    public ResponseEntity<?> deletarImagensOfProduct(@PathVariable Long id){
        if (productService.findById(id).isEmpty()){
            return ResponseEntity.badRequest().body("Produto não encontrado");
        }
        service.deleteAllImagesProduct(id);
        return ResponseEntity.ok("Imagens deletadas com sucesso");
    }

}
