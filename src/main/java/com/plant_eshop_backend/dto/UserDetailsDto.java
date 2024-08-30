package com.plant_eshop_backend.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDto {
    private String userDetailsId;
    private String userFirstName;
    private String userLastName;
    private String country;
    private String state;
    private String city;
    private String pincode;
    private String userAddress;
    private String userMobile;
}
