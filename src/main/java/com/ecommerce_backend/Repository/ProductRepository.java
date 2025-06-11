package com.ecommerce_backend.Repository;

import com.ecommerce_backend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
