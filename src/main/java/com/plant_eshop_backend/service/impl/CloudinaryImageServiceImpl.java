package com.plant_eshop_backend.service.impl;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.plant_eshop_backend.service.CloudinaryImageService;
@Service
public class CloudinaryImageServiceImpl implements CloudinaryImageService {
	@Autowired
    private Cloudinary cloudinary;
	
	@Override
	public Map upload(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
	        return uploadResult;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Image uploading failed..");
			
		}
		
	}

}
