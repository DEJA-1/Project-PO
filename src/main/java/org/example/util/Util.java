package org.example.util;

import java.util.Random;

public class Util {

    public static boolean checkIfDoAction(int targetPercentage) {
        Random random = new Random();
        int randomValue = random.nextInt(100) + 1;
        System.out.println("Drew number: " + randomValue);

        return randomValue <= targetPercentage;
    }
}