package com.ecommerce_backend.Controller;

import com.ecommerce_backend.Dto.Request.ProductRequestDto;
import com.ecommerce_backend.Dto.Response.ProductResponseDto;
import com.ecommerce_backend.Entity.Product;
import com.ecommerce_backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productRequestDto));
    }


    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable long productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/products/{productId}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable long productId, @RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto updatedProduct = productService.updateProduct(productId, productRequestDto);
        return ResponseEntity.ok(updatedProduct);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
