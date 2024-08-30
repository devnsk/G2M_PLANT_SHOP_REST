package com.plant_eshop_backend.repository;

import com.plant_eshop_backend.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepo extends JpaRepository<ProductImage,String> {
}
