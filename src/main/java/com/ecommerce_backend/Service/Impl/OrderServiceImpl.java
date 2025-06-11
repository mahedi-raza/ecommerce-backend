package com.ecommerce_backend.Service.Impl;

import com.ecommerce_backend.Dto.Request.OrderRequestDto;
import com.ecommerce_backend.Dto.Response.OrderResponseDto;
import com.ecommerce_backend.Entity.Order;
import com.ecommerce_backend.Entity.OrderItem;
import com.ecommerce_backend.Mapper.OrderItemMapper;
import com.ecommerce_backend.Mapper.OrderMapper;
import com.ecommerce_backend.Repository.OrderRepository;
import com.ecommerce_backend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;


    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
        Order order = orderMapper.toEntity(orderRequestDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }


    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public OrderResponseDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        return orderMapper.toDto(order);
    }


    @Override
    public OrderResponseDto updateOrder(Long orderId, OrderRequestDto orderRequestDto) {
       Order existingOrder = orderRepository.findById(orderId).orElseThrow();

       // Safety check that the user trying to update the order must be same.
        if(existingOrder.getUser().getUserId() != orderRequestDto.getUserId()) {
            throw new IllegalArgumentException("User mismatch: This User can't update the order!");
        }

        existingOrder.getOrderItems().clear();

        List<OrderItem> updatedItems = orderRequestDto.getOrderItems().stream()
                .map(orderItemRequestDto -> orderItemMapper.toEntity(orderItemRequestDto, existingOrder))
                .collect(Collectors.toList());

        existingOrder.setOrderItems(updatedItems);

        Order updated = orderRepository.save(existingOrder);
        return orderMapper.toDto(updated);
    }



    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }


}
