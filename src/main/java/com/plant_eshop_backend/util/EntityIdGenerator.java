package com.plant_eshop_backend.util;

import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EntityIdGenerator {
	public String generateStringId(String entityName) {
		String prefix = entityName.substring(0, 3).toUpperCase();
		String finalString = prefix.concat(UUID.randomUUID().toString().substring(0, 5));
		return finalString;
	}
}