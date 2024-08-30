package com.plant_eshop_backend.repository;

import com.plant_eshop_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.stream.Stream;

public interface CategoryRepo extends JpaRepository<Category,String> {

    @Query(value = "select c from Category c where c.categoryName=:cname")
    public Category getCategoryByName(@Param("cname")String categoryName);

    @Query(value = "select c.categoryName from Category c ")
    public Stream<String> getAllCategoryNames();
}
