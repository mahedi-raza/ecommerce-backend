package com.ecommerce_backend.Service.Impl;

import com.ecommerce_backend.Dto.Request.CategoryRequestDto;
import com.ecommerce_backend.Dto.Response.CategoryResponseDto;
import com.ecommerce_backend.Entity.Category;
import com.ecommerce_backend.Mapper.CategoryMapper;
import com.ecommerce_backend.Repository.CategoryRepository;
import com.ecommerce_backend.Service.CategoryService;
import com.ecommerce_backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = categoryMapper.toEntity(categoryRequestDto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }


    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper ::toDto).toList();
    }


    @Override
    public CategoryResponseDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("Category Not Found!"));
        return categoryMapper.toDto(category);
    }


    @Override
    public CategoryResponseDto updateCategory(Long categoryId, CategoryRequestDto categoryRequestDto) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category Not found with categoryId: "+categoryId));

        category.setCategoryName(categoryRequestDto.getCategoryName());
        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(updatedCategory);
    }


    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
