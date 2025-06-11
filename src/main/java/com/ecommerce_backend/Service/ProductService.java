package com.ecommerce_backend.Service;

import com.ecommerce_backend.Dto.Request.ProductRequestDto;
import com.ecommerce_backend.Dto.Response.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(Long productId);

    ProductResponseDto updateProduct(Long productId, ProductRequestDto productRequestDto);

    void deleteProduct(Long productId);
}
