package com.plant_eshop_backend.repository;

import com.plant_eshop_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.stream.Stream;

public interface ProductRepo extends JpaRepository<Product,String> {
    @Query(value = "select p.productName from Product p")
    public Stream<String> getAllProductNames();
}
