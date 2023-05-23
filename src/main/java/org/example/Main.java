package org.example;

import org.example.people.Adult;
import org.example.people.Child;
import org.example.people.Elder;
import org.example.results.Results;
import org.example.util.ProjectUtils;
import org.example.virus.Acutus;
import org.example.virus.Virolexia;
import org.example.virus.Virus;

import java.util.ArrayList;
import java.util.HashMap;

import static org.example.util.ProjectUtils.getInputData;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Object> data = getInputData();

        ArrayList<Child> children = getChildren((Integer) data.get("children"));
        ArrayList<Adult> adults = getAdults((Integer) data.get("adults"));
        ArrayList<Elder> elders = getElders((Integer) data.get("elders"));

        int days = (int) data.get("days");
        Virus virus = (Virus) data.get("virus");

        Results results = new Results(children, adults, elders, virus, days);

        runSimulation(children, adults, elders, virus, days, results);
    }

    public static void runSimulation(ArrayList<Child> children, ArrayList<Adult> adults, ArrayList<Elder> elders , Virus virus, int days, Results results) {
        for (int i = 0; i < days; i++) {

            for (Child child : children) {
                // before infection
                child.tryAvoidPhysicalContact();

                // infection
                String st = child.getStatus();
                if (st == "notInfected") {
                    virus.infect(child);
                }

                // after infection
                child.tryToHeal();
                printInfo(child);
            }

            for (Adult adult : adults) {
                // before infection
                adult.tryAvoidPhysicalContact();
                adult.tryVaccinate();

                // infection
                String st = adult.getStatus();
                if (st == "notInfected") {
                    virus.infect(adult);
                }

                // after infection
                adult.tryToHeal();
                printInfo(adult);
            }

            for (Elder elder : elders) {
                boolean isDead = elder.getIsDead();
                if (!isDead) {
                    // before infection
                    elder.tryAvoidPhysicalContact();
                    elder.tryVaccinate();

                    //infection

                    String st = elder.getStatus();
                    if (st == "notInfected") {
                        virus.infect(elder);
                    }
                    // after infection
                    elder.tryToHeal();
                    elder.tryDie();
                }

                printInfo(elder);
            }
        }

        results.printResults();
    }

    public static ArrayList<Child> getChildren(int n) {
        ArrayList<Child> children = new ArrayList<Child>();

        for (int i = 0; i < n; i++) {
            String name = ProjectUtils.generateName();
            Child child = new Child(name, 25, "notInfected", false, false);
            children.add(child);
        }

        return children;
    }

    public static ArrayList<Adult> getAdults(int n) {
        ArrayList<Adult> adults = new ArrayList<Adult>();

        for (int i = 0; i < n; i++) {
            String name = ProjectUtils.generateName();
            Adult adult = new Adult(name, 30, 25, "notInfected", false, false, false);
            adults.add(adult);
        }

        return adults;
    }

    public static ArrayList<Elder> getElders(int n) {
        ArrayList<Elder> elders = new ArrayList<Elder>();

        for (int i = 0; i < n; i++) {
            String name = ProjectUtils.generateName();
            Elder elder = new Elder(name, 30, 40, 35, "notInfected", false, false, false, false);
            elders.add(elder);
        }

        return elders;
    }

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