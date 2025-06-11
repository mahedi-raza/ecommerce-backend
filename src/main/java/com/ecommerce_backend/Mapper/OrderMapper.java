package com.ecommerce_backend.Mapper;

import com.ecommerce_backend.Dto.Request.OrderRequestDto;
import com.ecommerce_backend.Dto.Response.OrderItemResponseDto;
import com.ecommerce_backend.Dto.Response.OrderResponseDto;
import com.ecommerce_backend.Dto.Response.UserResponseDto;
import com.ecommerce_backend.Entity.Order;
import com.ecommerce_backend.Entity.OrderItem;
import com.ecommerce_backend.Entity.Product;
import com.ecommerce_backend.Entity.User;
import com.ecommerce_backend.Repository.ProductRepository;
import com.ecommerce_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;


    public Order toEntity(OrderRequestDto orderRequestDto){
        User user = userRepository.findById(orderRequestDto.getUserId()).orElseThrow();

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = orderRequestDto.getOrderItems().stream()
                .map(orderItemRequestDto -> orderItemMapper.toEntity(orderItemRequestDto, order))
                .collect(Collectors.toList());

        order.setOrderItems(orderItems);
        return order;
    }


    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderId(order.getOrderId());
        orderResponseDto.setOrderDate(order.getOrderDate());

        User user = order.getUser();
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());

        orderResponseDto.setUserResponseDto(userResponseDto);

        List<OrderItemResponseDto> orderItemResponseDtoList = order.getOrderItems().stream()
                .map(orderItemMapper::toDto).collect(Collectors.toList());

        orderResponseDto.setOrderItems(orderItemResponseDtoList);
        return orderResponseDto;
    }
}
