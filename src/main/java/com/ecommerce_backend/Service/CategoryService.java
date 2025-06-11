package com.ecommerce_backend.Service;

import com.ecommerce_backend.Dto.Request.CategoryRequestDto;
import com.ecommerce_backend.Dto.Response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);

    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto getCategoryById(Long categoryId);

    CategoryResponseDto updateCategory(Long categoryId, CategoryRequestDto categoryRequestDto);

    void deleteCategory(Long categoryId);
}
