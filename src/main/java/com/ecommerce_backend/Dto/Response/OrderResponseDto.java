package com.ecommerce_backend.Dto.Response;

import java.time.LocalDate;
import java.util.List;

public class OrderResponseDto {

    private long orderId;
    private LocalDate orderDate;
    private UserResponseDto userResponseDto;
    private List<OrderItemResponseDto> orderItems;


    public OrderResponseDto() {
    }


    public OrderResponseDto(long orderId, LocalDate orderDate, UserResponseDto userResponseDto, List<OrderItemResponseDto> orderItems) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.userResponseDto = userResponseDto;
        this.orderItems = orderItems;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public UserResponseDto getUserResponseDto() {
        return userResponseDto;
    }

    public void setUserResponseDto(UserResponseDto userResponseDto) {
        this.userResponseDto = userResponseDto;
    }

    public List<OrderItemResponseDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemResponseDto> orderItems) {
        this.orderItems = orderItems;
    }
}
