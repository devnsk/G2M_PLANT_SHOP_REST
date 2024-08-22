package com.plant_eshop_backend.config;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class ImageUploadConfig {
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
	@Value("${cloudinary.api_key}")
	private String key;
	@Value("${cloudinary.api_secret}")
	private String secret;
	@Value("${cloudinary.cloud_name}")
	private String cloudName;

	@Bean
	public Cloudinary getCloudinary() {
		Map map = new HashMap();
		map.put("cloud_name", cloudName);
		map.put("api_key", key);
		map.put("api_secret", secret);
		map.put("secure", true);

		return new Cloudinary(map);
	}

}
