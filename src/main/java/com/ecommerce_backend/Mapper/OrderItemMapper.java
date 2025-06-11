package com.ecommerce_backend.Mapper;

import com.ecommerce_backend.Dto.Request.OrderItemRequestDto;
import com.ecommerce_backend.Dto.Response.OrderItemResponseDto;
import com.ecommerce_backend.Entity.Order;
import com.ecommerce_backend.Entity.OrderItem;
import com.ecommerce_backend.Entity.Product;
import com.ecommerce_backend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    @Autowired
    private ProductRepository productRepository;

    public OrderItem toEntity(OrderItemRequestDto orderItemRequestDto, Order order){
        Product product = productRepository.findById(orderItemRequestDto.getProductId()).orElseThrow();

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(orderItemRequestDto.getQuantity());

        double currentProductPrice = product.getProductPrice();
        orderItem.setPrice(currentProductPrice);
        orderItem.setOrder(order);

        return orderItem;
    }


    public OrderItemResponseDto toDto(OrderItem orderItem) {
        OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto();
        orderItemResponseDto.setProductName(orderItem.getProduct().getProductName());
        orderItemResponseDto.setQuantity(orderItem.getQuantity());
        orderItemResponseDto.setPrice(orderItem.getPrice());

        return orderItemResponseDto;
    }
}
