package com.plant_eshop_backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	public static kong.unirest.JsonNode sendSimpleMessage() throws UnirestException {
//  		kong.unirest.HttpResponse<kong.unirest.JsonNode> request = Unirest.post("https://api.mailgun.net/v3/sandbox7b659fe2b51040be8a7e011dcc9ae75b.mailgun.org/messages")
//  			.basicAuth("api", API_KEY)
//  			.queryString("from", "Excited User <USER@sandbox7b659fe2b51040be8a7e011dcc9ae75b.mailgun.org>")
//  			.queryString("to", "nskdeb93@gmail.com")
//  			.queryString("subject", "Mailgun")
//  			.queryString("text", "Testing The Mailgun Nigga")
//  			.asJson();
//  		return request.getBody();
		return null;
}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("Starting the Mailgun Servie");
//		JsonNode node = Application.sendSimpleMessage();
//		System.out.println(node);
		  
		  	 // ...
		  

}
}
