package com.plant_eshop_backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class UserDto {
    private String userId;
    private String userEmail;
    private String userPassword;
    private String role;
    private UserDetailsDto userDetailsDto;
}
