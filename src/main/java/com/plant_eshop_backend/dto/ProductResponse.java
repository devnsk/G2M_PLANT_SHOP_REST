package com.plant_eshop_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
    private ProductDto dto;
}
