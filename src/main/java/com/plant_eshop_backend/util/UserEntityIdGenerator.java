package com.plant_eshop_backend.util;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class UserEntityIdGenerator {
    public String generateUserCustomId(String entityName) {
        String prefix = entityName.substring(0, 3).toUpperCase();

        // Generate a random two-digit number
        Random random = new Random();
        int randomNumber = random.nextInt(90) + 10; // Generates a number between 10 and 99

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(DateTimeFormatter.ofPattern("dd:MM"));
        String time = now.format(DateTimeFormatter.ofPattern("HH:mm"));

        // Combine to form the final ID
        String finalId = String.format("%s-%d-D%s-T%s", prefix, randomNumber, date, time);

        return finalId;
    }
}
