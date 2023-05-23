package org.example.results;

import org.example.people.Adult;
import org.example.people.Child;
import org.example.people.Elder;
import org.example.virus.Virus;

import java.util.ArrayList;

public class Results {

    private int days;

    private Virus virus;
    public static int infectionCount = 0;
    public static int healedCount = 0;

    public static int deadCount = 0;

    public static int vaccinatedCount = 0;

    private final ArrayList<Child> children;
    private final ArrayList<Adult> adults;
    private final ArrayList<Elder> elders;
    public Results(ArrayList<Child> children, ArrayList<Adult> adults, ArrayList<Elder> elders, Virus virus, int days) {
        this.children = children;
        this.adults = adults;
        this.elders = elders;
        this.days = days;
        this.virus = virus;
    }


    public void printResults() {
        System.out.println("Children: " + children.size() + " | Adults: " + adults.size() + " | Elders: " + elders.size() + " | virus: " + virus + " | days: " + days);
        System.out.println("Infected people: " + infectionCount + "\nHealed people: " + healedCount + "\nDead people: " + deadCount + "\nVaccinated people: " + vaccinatedCount);
    }
}
