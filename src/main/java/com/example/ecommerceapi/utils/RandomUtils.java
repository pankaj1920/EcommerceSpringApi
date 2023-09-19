package com.example.ecommerceapi.utils;

import java.util.Random;

public class RandomUtils {


    public static String generateOTP(int length) {
        // Define characters allowed in the OTP
        String allowedChars = "0123456789";

        // Create a random object
        Random random = new Random();

        // Initialize a StringBuilder to store the OTP
        StringBuilder otp = new StringBuilder(length);

        // Generate OTP of the specified length
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(randomIndex);
            otp.append(randomChar);
        }

        return otp.toString();
    }
}
