package com.ecommerce_backend.Mapper;

import com.ecommerce_backend.Dto.Request.ProductRequestDto;
import com.ecommerce_backend.Dto.Response.ProductResponseDto;
import com.ecommerce_backend.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setProductName(productRequestDto.getProductName());
        product.setProductPrice(productRequestDto.getProductPrice());
        return product;
    }

    public ProductResponseDto toDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductId(product.getProductId());
        productResponseDto.setProductName(product.getProductName());
        productResponseDto.setProductPrice(product.getProductPrice());
        productResponseDto.setCategoryId(product.getCategory().getCategoryId());
        return productResponseDto;
    }
}
