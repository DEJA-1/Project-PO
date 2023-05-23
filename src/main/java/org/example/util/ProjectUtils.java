package org.example.util;

import java.util.Random;

public class ProjectUtils {

    public static boolean checkIfDoAction(int targetPercentage) {
        Random random = new Random();
        int randomValue = random.nextInt(100) + 1;

        return randomValue <= targetPercentage;
    }

    public static String generateName() {
        int length = 6;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);

            sb.append(randomChar);
        }

        return sb.toString();
    }
}
