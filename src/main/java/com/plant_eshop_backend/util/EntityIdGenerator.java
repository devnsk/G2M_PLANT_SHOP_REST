package com.plant_eshop_backend.util;


import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class EntityIdGenerator {

	public String generateStringId(String entityName) {

		Random random = new Random();
		int randomNumber = random.nextInt(99000) + 1000;  // Generates a number between 100 and 999


		StringBuilder randomLetters = new StringBuilder(2);
		for (int i = 0; i < 2; i++) {
			char letter = (char) (random.nextInt(26) + 'a'); // Lowercase letters a-z
			randomLetters.append(letter);
		}


		return String.format("%s-%d%s", entityName, randomNumber, randomLetters.toString());
	}
}