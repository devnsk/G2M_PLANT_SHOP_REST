package com.plant_eshop_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_tb")
public class User {
	@Id
	private String userId;
	private String userEmail;
	private String userPassword;
	private String userName;
	
	
	

}
