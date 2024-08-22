package com.plant_eshop_backend.controller;

import com.plant_eshop_backend.dto.UserDetailsDto;
import com.plant_eshop_backend.dto.UserDto;
import com.plant_eshop_backend.dto.UserResponse;
import com.plant_eshop_backend.entity.Role;
import com.plant_eshop_backend.entity.User;
import com.plant_eshop_backend.entity.UserDetails;
import com.plant_eshop_backend.repository.UserRepository;
import com.plant_eshop_backend.service.UserService;
import com.plant_eshop_backend.util.EntityIdGenerator;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody Map<String, String> credentials) {
        System.out.println("Inside Login");
        String email = credentials.get("email");
        String password = credentials.get("password");
        UserResponse user = userService.getCheckUser(email, password);
        System.out.println("UserResponse"+user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
