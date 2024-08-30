package com.plant_eshop_backend.repository;

import com.plant_eshop_backend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("Select u from User u where u.userEmail=:email and u.userPassword=:pwd")
     User checkUser(@Param("email")String email, @Param("pwd")String pass);



}