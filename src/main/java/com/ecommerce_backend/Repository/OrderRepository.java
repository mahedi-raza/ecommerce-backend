package com.ecommerce_backend.Repository;

import com.ecommerce_backend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
