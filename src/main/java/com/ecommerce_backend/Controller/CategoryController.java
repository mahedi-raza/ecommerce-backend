package com.ecommerce_backend.Controller;

import com.ecommerce_backend.Dto.Request.CategoryRequestDto;
import com.ecommerce_backend.Dto.Response.CategoryResponseDto;
import com.ecommerce_backend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryRequestDto));
    }


    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }


    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable long categoryId){
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }


    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable long categoryId, @RequestBody CategoryRequestDto categoryRequestDto){
        CategoryResponseDto updatedCategory = categoryService.updateCategory(categoryId, categoryRequestDto);
        return ResponseEntity.ok(updatedCategory);
    }


    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}
