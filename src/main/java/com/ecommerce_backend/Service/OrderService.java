package com.ecommerce_backend.Service;

import com.ecommerce_backend.Dto.Request.OrderRequestDto;
import com.ecommerce_backend.Dto.Response.OrderResponseDto;

import java.util.List;

public interface OrderService {

    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);

    List<OrderResponseDto> getAllOrders();

    OrderResponseDto getOrderById(Long orderId);

    OrderResponseDto updateOrder(Long orderId, OrderRequestDto orderRequestDto);

    void deleteOrder(Long orderId);
}
