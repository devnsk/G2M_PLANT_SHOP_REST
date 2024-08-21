package com.plant_eshop_backend.controller;

import com.plant_eshop_backend.dto.UserDetailsDto;
import com.plant_eshop_backend.dto.UserDto;
import com.plant_eshop_backend.entity.Role;
import com.plant_eshop_backend.entity.User;
import com.plant_eshop_backend.entity.UserDetails;
import com.plant_eshop_backend.repository.UserRepository;
import com.plant_eshop_backend.service.UserService;
import com.plant_eshop_backend.util.EntityIdGenerator;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User Login(@RequestBody Map<String, String> credential ) {
        System.out.println("Inside Login");
        String email = credential.get("email");
        String password = credential.get("password");
        User user= userService.checkUserRole(email,password);
        if(user!=null){
            return  user;
        }else {
            return null;
        }
    }

}