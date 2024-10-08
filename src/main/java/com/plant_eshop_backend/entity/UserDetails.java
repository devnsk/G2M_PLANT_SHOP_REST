package com.plant_eshop_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userdetails_tb")
public class UserDetails {

    @Id
    private String userDetailsId;

    private String userFirstName;

    private String userLastName;

    private String country;

    private String state;

    private String city;

    private String pincode;

    private String userAddress;


    private String userMobile;

//    @CreationTimestamp
//    private LocalDateTime createdTime;

}
