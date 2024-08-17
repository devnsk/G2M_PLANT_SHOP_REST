package com.plant_eshop_backend.util;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class EntityIdGenerator {
               String generateStringId(String entityName) {
            	   String prefix = entityName.substring(0, 4).toUpperCase();
            	   String suffix = String.valueOf(new Date().getTime()).substring(10,13);
            	   String finalString = prefix.concat(UUID.randomUUID().toString().substring(0,5)).concat(suffix);
            	   return finalString;
               }
}
