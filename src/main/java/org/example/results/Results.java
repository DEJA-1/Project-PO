package org.example.results;

public class Results {
    public static int infectionCount = 0;

    public static int healedCount = 0;

    public static int deadCount = 0;

    public static int vaccinatedCount = 0;

    public static void printResults() {
        System.out.println("Infected people: " + infectionCount + "\nHealed people: " + healedCount + "\nDead people: " + deadCount + "\nVaccinated people: " + vaccinatedCount);
    }
}
