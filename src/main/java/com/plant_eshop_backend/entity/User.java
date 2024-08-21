package com.plant_eshop_backend.entity;

import com.plant_eshop_backend.util.EntityIdGenerator;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user_tb")
public class User {

	@Id
	private String userId;

	private String userEmail;

	private String userPassword;

	@ManyToOne
	@JoinColumn(name = "Role_ID")
	private Role urole;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserDetail_Id")
	private UserDetails udetail;

}

