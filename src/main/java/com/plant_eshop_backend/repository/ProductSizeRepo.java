package com.plant_eshop_backend.repository;


import com.plant_eshop_backend.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSizeRepo extends JpaRepository<ProductSize,String> {
}
