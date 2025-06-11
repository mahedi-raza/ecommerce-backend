package com.ecommerce_backend.Dto.Response;

public class ProductResponseDto {

    private Long productId;
    private String productName;
    private double productPrice;
    private long categoryId;

    public ProductResponseDto() {

    }

    public ProductResponseDto(Long productId, String productName, double productPrice, long categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryId = categoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
