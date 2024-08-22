package com.plant_eshop_backend.dto;


import com.plant_eshop_backend.entity.User;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
    private User user;
}
