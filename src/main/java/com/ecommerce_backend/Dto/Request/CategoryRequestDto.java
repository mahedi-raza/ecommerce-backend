package com.ecommerce_backend.Dto.Request;

public class CategoryRequestDto {

    private String categoryName;

    public CategoryRequestDto() {

    }

    public CategoryRequestDto(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
