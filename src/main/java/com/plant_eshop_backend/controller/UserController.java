package com.plant_eshop_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plant_eshop_backend.service.MailgunService;

@RestController
public class UserController {
	@Autowired
	private MailgunService mailService;
   
	@GetMapping("/sendEmail")
	public kong.unirest.JsonNode sendEmail(){
		return mailService.sendSimpleMessage();
	}
}
