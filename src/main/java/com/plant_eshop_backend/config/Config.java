package com.plant_eshop_backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;

@Configuration
public class Config {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

}