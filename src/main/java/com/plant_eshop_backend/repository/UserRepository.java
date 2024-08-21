package com.plant_eshop_backend.repository;

import com.plant_eshop_backend.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query(value = "SELECT * FROM user_tb WHERE user_id = :userId", nativeQuery = true)
    User findByUserId(@Param("userId") String userId);

}