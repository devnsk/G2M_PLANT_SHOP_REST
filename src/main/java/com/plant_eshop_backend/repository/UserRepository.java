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

    @Query("Select u from User u where u.userEmail=:email and u.userPassword=:pwd")
     User checkUser(@Param("email")String email, @Param("pwd")String pass);

//    @Query("select u from User u where u.userId = :userId")
//    User findByUserId(@Param("userId") String userId);

}