package com.ecommerce_backend.Dto.Request;

import java.util.List;

public class OrderRequestDto {

    private long userId;
    private List<OrderItemRequestDto> orderItems;


    public OrderRequestDto() {

    }

    public OrderRequestDto(long userId, List<OrderItemRequestDto> orderItems) {
        this.userId = userId;
        this.orderItems = orderItems;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<OrderItemRequestDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemRequestDto> orderItems) {
        this.orderItems = orderItems;
    }
}
