package org.example.util;

import org.example.people.Adult;
import org.example.people.Child;
import org.example.people.Elder;
import org.example.virus.Acutus;
import org.example.virus.Virolexia;
import org.example.virus.Virus;

import java.util.ArrayList;
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

        getData(scanner, data, "children");

        getData(scanner, data, "adults");

        getData(scanner, data, "elders");

        getData(scanner, data, "days");

        getVirus(scanner, data);

        return data;
    }

    /**
     * Gets data.
     *
     * @param scanner  the scanner
     * @param data     the data
     * @param dataType the data type
     */
    public static void getData(Scanner scanner, HashMap<String, Object> data, String dataType) {
        System.out.println("Enter amount of " + dataType + ": ");
        int amount = scanner.nextInt();
        data.put(dataType, amount);
    }

    /**
     * Gets virus.
     *
     * @param scanner the scanner
     * @param data    the data
     */
    public static void getVirus(Scanner scanner, HashMap<String, Object> data) {
        System.out.println("Choose virus: \n[1] - Acutus\n[2] - Virolexia");
        int input = scanner.nextInt();
        Virus virus;

        if (input == 1) {
            virus = new Acutus(50, "Acutus");
            data.put("virus", virus);
        } else if (input == 2) {
            virus = new Virolexia(80, "Virolexia");
            data.put("virus", virus);
        } else {
            System.out.println("Invalid input.");
        }
    }

    /**
     * Gets children.
     *
     * @param n the n
     * @return the children
     */
    public static ArrayList<Child> getChildren(int n) {
        ArrayList<Child> children = new ArrayList<Child>();

        for (int i = 0; i < n; i++) {
            String name = ProjectUtils.generateName();
            Child child = new Child(name, 25, "notInfected", false, false);
            children.add(child);
        }

        return children;
    }

    /**
     * Gets adults.
     *
     * @param n the n
     * @return the adults
     */
    public static ArrayList<Adult> getAdults(int n) {
        ArrayList<Adult> adults = new ArrayList<Adult>();

        for (int i = 0; i < n; i++) {
            String name = ProjectUtils.generateName();
            Adult adult = new Adult(name, 30, 25, "notInfected", false, false, false);
            adults.add(adult);
        }

        return adults;
    }

    /**
     * Gets elders.
     *
     * @param n the n
     * @return the elders
     */
    public static ArrayList<Elder> getElders(int n) {
        ArrayList<Elder> elders = new ArrayList<Elder>();

        for (int i = 0; i < n; i++) {
            String name = ProjectUtils.generateName();
            Elder elder = new Elder(name, 30, 40, 35, "notInfected", false, false, false, false);
            elders.add(elder);
        }

        return elders;
    }

    /**
     * Print info.
     *
     * @param person the person
     */
    public static void printInfo(Child person) {
        String personName = person.getName();
        String personStatus = person.getStatus();
        int personHealChance = person.getHealChance();
        boolean personHasHeartache = person.getHeartache();
        boolean personHasPhlegm = person.getPhlegm();
        boolean personIsVaccinated = person.getIsVaccinated();
        boolean personIsDead = person.getIsDead();

        System.out.println("---------------------------------------------");
        System.out.println(personName + " info:\nstatus: " + personStatus + "\nheal chance: " + personHealChance + "\nheartache: " + personHasHeartache + "\nphlegm: " + personHasPhlegm + "\nvaccinated: " + personIsVaccinated + "\ndead: " + personIsDead);
        System.out.println("---------------------------------------------");
    }


}
