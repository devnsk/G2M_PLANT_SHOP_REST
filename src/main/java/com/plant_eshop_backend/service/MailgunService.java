package com.plant_eshop_backend.service;


import org.springframework.stereotype.Service;

import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Service
public class MailgunService {
	
	   private static final String API_KEY = "47c7993d7c3240e5616d289fd94b41db-911539ec-67f79eb9";
	  	 // ...
	  	public static kong.unirest.JsonNode sendSimpleMessage() throws UnirestException {
	  		kong.unirest.HttpResponse<kong.unirest.JsonNode> request = Unirest.post("https://api.mailgun.net/v3/sandbox7b659fe2b51040be8a7e011dcc9ae75b.mailgun.org/messages")
	  			.basicAuth("api", API_KEY)
	  			.queryString("from", "Excited User <USER@sandbox7b659fe2b51040be8a7e011dcc9ae75b.mailgun.org>")
	  			.queryString("to", "nskdeb93@gmail.com")
	  			.queryString("subject", "Mailgun")
	  			.queryString("text", "Testing The Mailgun Nigga")
	  			.asJson();
	  		return request.getBody();
	  	}
	  }

