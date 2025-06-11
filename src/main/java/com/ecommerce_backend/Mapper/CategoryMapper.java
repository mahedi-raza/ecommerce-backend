package com.ecommerce_backend.Mapper;


import com.ecommerce_backend.Dto.Request.CategoryRequestDto;
import com.ecommerce_backend.Dto.Response.CategoryResponseDto;
import com.ecommerce_backend.Entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDto categoryRequestDto){
        Category category = new Category();
        category.setCategoryName(categoryRequestDto.getCategoryName());
        return category;
    }

    public CategoryResponseDto toDto(Category category){
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setCategoryId(category.getCategoryId());
        categoryResponseDto.setCategoryName(category.getCategoryName());
        return categoryResponseDto;
    }
}
