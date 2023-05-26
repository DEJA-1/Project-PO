package org.example.util;

import org.example.virus.Acutus;
import org.example.virus.Virolexia;
import org.example.virus.Virus;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * The type Project utils.
 */
public class ProjectUtils {

    /**
     * Check if do action boolean.
     *
     * @param targetPercentage the target percentage
     * @return the boolean
     */
    public static boolean checkIfDoAction(int targetPercentage) {
        Random random = new Random();
        int randomValue = random.nextInt(100) + 1;

        return randomValue <= targetPercentage;
    }

    /**
     * Generate name string.
     *
     * @return the string
     */
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

    /**
     * Gets input data.
     *
     * @return the input data
     */
    public static HashMap<String, Object> getInputData() {
        HashMap<String, Object> data = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount of children: ");
        int amountOfChildren = scanner.nextInt();
        data.put("children", amountOfChildren);

        System.out.println("Enter amount of adults: ");
        int amountOfAdults = scanner.nextInt();
        data.put("adults", amountOfAdults);

        System.out.println("Enter amount of elders: ");
        int amountOfElders = scanner.nextInt();
        data.put("elders", amountOfElders);

        System.out.println("Enter duration of the pandemic (days)");
        int days = scanner.nextInt();
        data.put("days", days);

        System.out.println("Choose virus: \n[1] - Acutus\n[2] - Virolexia");
        int input = scanner.nextInt();

        switch (input) {
            case 1: {
                Virus virus1 = new Acutus();
                data.put("virus", virus1);
            }

            case 2: {
                Virus virus2 = new Virolexia();
                data.put("virus", virus2);
            }
        }

        return data;
    }


}
