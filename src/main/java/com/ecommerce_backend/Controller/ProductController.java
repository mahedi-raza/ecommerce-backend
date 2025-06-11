package com.ecommerce_backend.Controller;

import com.ecommerce_backend.Dto.Request.ProductRequestDto;
import com.ecommerce_backend.Dto.Response.ProductResponseDto;
import com.ecommerce_backend.Entity.Product;
import com.ecommerce_backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productRequestDto));
    }


    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }


    @PutMapping("/products/{productId}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable long productId, @RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto updatedProduct = productService.updateProduct(productId, productRequestDto);
        return ResponseEntity.ok(updatedProduct);
    }


    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
