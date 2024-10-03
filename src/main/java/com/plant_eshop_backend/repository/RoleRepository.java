package com.plant_eshop_backend.repository;

import com.plant_eshop_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("Select r from Role r where r.role_name=:role")
    public  Role getRoleName(@Param("role") String role);
}
