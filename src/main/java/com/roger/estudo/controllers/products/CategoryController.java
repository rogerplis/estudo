package com.roger.estudo.controllers.products;

import com.roger.estudo.services.products.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ResponseEntity<?> buscarCategorias(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("filter/")
    public ResponseEntity<?> buscarPorNome(@RequestParam String name){
        if(categoryService.findByName(name).isEmpty()) return ResponseEntity.badRequest().body("Category not exist");
        return ResponseEntity.ok(categoryService.findByName(name));
    }

}
