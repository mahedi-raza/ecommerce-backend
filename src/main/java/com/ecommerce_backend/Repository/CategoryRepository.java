package com.ecommerce_backend.Repository;

import com.ecommerce_backend.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
