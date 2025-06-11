package com.ecommerce_backend.Dto.Request;

public class OrderItemRequestDto {

    private long productId;
    private int quantity;

    public OrderItemRequestDto() {

    }

    public OrderItemRequestDto(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
