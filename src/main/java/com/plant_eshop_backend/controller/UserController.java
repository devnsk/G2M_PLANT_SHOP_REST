package com.plant_eshop_backend.controller;

import com.plant_eshop_backend.dto.UserDto;
import com.plant_eshop_backend.entity.Product;
import com.plant_eshop_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.saveUser(userDto));
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {
        UserDto userDto = userService.getUserById(userId);
        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{Uid}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String Uid, @RequestBody UserDto userDetails) {
        UserDto updatedUser = userService.updateUserById(Uid, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/product")
    private String ss(@RequestBody Product product){
        System.out.println(product);
        System.out.println("2nd");
        return "hekk";
    }
}
