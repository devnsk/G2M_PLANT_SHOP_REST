package com.plant_eshop_backend.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "userdetails_tb")
public class UserDetails {
	@Id
    private String userDetailsId;
    private String userFirstName;
    private String userLastName;
    private String userAddress;
    private String userMobile;
    
    @CreationTimestamp
    private LocalDateTime createdTime;
    
    
}
