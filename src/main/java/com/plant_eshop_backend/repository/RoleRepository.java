package com.plant_eshop_backend.repository;

import com.plant_eshop_backend.entity.Role;
import com.plant_eshop_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    @Query(value = "Select u from User u where u.userEmail=:email and u.userPassword=:pwd")
    public User checkRole(@Param("email")String email, @Param("pwd")String pass);

    @Query(value = "Select r from Role r where r.role_name=:role")
    public  Role getRoleName(@Param("role") String role);
}
