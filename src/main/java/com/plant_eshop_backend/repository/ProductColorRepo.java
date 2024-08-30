package com.plant_eshop_backend.repository;


import com.plant_eshop_backend.entity.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorRepo extends JpaRepository<ProductColor,String> {
}
