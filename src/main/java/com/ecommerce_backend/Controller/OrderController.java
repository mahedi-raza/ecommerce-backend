package com.ecommerce_backend.Controller;

import com.ecommerce_backend.Dto.Request.OrderRequestDto;
import com.ecommerce_backend.Dto.Response.OrderResponseDto;
import com.ecommerce_backend.Dto.Response.ProductResponseDto;
import com.ecommerce_backend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PreAuthorize("hasRole('USER')")
    @PostMapping("/orders")
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.placeOrder(orderRequestDto));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable long orderId){
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/orders/{orderId}")
    public ResponseEntity<OrderResponseDto> updateOrder(@PathVariable long orderId, @RequestBody OrderRequestDto orderRequestDto){
        OrderResponseDto updatedOrder = orderService.updateOrder(orderId, orderRequestDto);
        return ResponseEntity.ok(updatedOrder);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
