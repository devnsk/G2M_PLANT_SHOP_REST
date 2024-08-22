package com.plant_eshop_backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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
