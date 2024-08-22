package com.plant_eshop_backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;

@Configuration
public class Config {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}