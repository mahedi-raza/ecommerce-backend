package com.ecommerce_backend.Dto.Request;

public class ProductRequestDto {

    private String productName;
    private double productPrice;
    private long categoryId;

    public ProductRequestDto() {

    }

    public ProductRequestDto(String productName, double productPrice, long categoryId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
