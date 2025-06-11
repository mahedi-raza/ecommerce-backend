package com.ecommerce_backend.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;


    public Category() {

    }

    public Category(long categoryId, String categoryName, List<Product> products) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.products = products;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
