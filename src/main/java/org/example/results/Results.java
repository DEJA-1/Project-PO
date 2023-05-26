package org.example.results;

import org.example.people.Adult;
import org.example.people.Child;
import org.example.people.Elder;
import org.example.virus.Virus;

import java.util.ArrayList;

/**
 * The type Results.
 */
public class Results {

    private int days;

    private Virus virus;
    /**
     * The constant infectionCount.
     */
    public static int infectionCount = 0;
    /**
     * The constant healedCount.
     */
    public static int healedCount = 0;

    /**
     * The constant deadCount.
     */
    public static int deadCount = 0;

    /**
     * The constant vaccinatedCount.
     */
    public static int vaccinatedCount = 0;

    private final ArrayList<Child> children;
    private final ArrayList<Adult> adults;
    private final ArrayList<Elder> elders;

    /**
     * Instantiates a new Results.
     *
     * @param children the children
     * @param adults   the adults
     * @param elders   the elders
     * @param virus    the virus
     * @param days     the days
     */
    public Results(ArrayList<Child> children, ArrayList<Adult> adults, ArrayList<Elder> elders, Virus virus, int days) {
        this.children = children;
        this.adults = adults;
        this.elders = elders;
        this.days = days;
        this.virus = virus;
    }


    /**
     * Print results.
     */
    public void printResults() {
        System.out.println("Children: " + children.size() + " | Adults: " + adults.size() + " | Elders: " + elders.size() + " | virus: " + virus + " | days: " + days);
        System.out.println("Infected people: " + infectionCount + "\nHealed people: " + healedCount + "\nDead people: " + deadCount + "\nVaccinated people: " + vaccinatedCount);
    }
}
