package com.ecommerce_backend.Service.Impl;

import com.ecommerce_backend.Dto.Request.ProductRequestDto;
import com.ecommerce_backend.Dto.Response.ProductResponseDto;
import com.ecommerce_backend.Entity.Category;
import com.ecommerce_backend.Entity.Product;
import com.ecommerce_backend.Mapper.ProductMapper;
import com.ecommerce_backend.Repository.CategoryRepository;
import com.ecommerce_backend.Repository.ProductRepository;
import com.ecommerce_backend.Service.ProductService;
import com.ecommerce_backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toEntity(productRequestDto);
        // Fetch category from DB using categoryId in the request
        Category category = categoryRepository.findById(productRequestDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Set the category in the product entity
        product.setCategory(category);

        // Save and return
        productRepository.save(product);
        return productMapper.toDto(product);
    }


    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }


    @Override
    public ProductResponseDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found!"));
        return productMapper.toDto(product);
    }


    @Override
    public ProductResponseDto updateProduct(Long productId, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found with id: "+productId));

        product.setProductName(productRequestDto.getProductName());
        product.setProductPrice(productRequestDto.getProductPrice());
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
