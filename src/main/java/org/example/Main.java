package org.example;

import org.example.people.Adult;
import org.example.people.Child;
import org.example.people.Elder;
import org.example.results.Results;
import org.example.util.ProjectUtils;
import org.example.virus.Acutus;
import org.example.virus.Virus;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Child> children = getChildren(20);
        ArrayList<Adult> adults = getAdults(20);
        ArrayList<Elder> elders = getElders(20);
        Virus acutus = new Acutus();

        runSimulation(children, adults, elders, acutus, 10);

    }

    /*
    Zbugowany healChance
     */
    public static void runSimulation(ArrayList<Child> children, ArrayList<Adult> adults, ArrayList<Elder> elders , Virus virus, int days) {
        for (int i = 0; i < days; i++) {
            for (Child child : children) {
                // before infection
                child.tryAvoidPhysicalContact();

                // infection
                virus.infect(child);

                // after infection
                child.tryToHeal();
            }

            for (Adult adult : adults) {
                // before infection
                adult.tryAvoidPhysicalContact();
                adult.tryVaccinate();

                // infection
                virus.infect(adult);

                // after infection
                adult.tryToHeal();

            }

            for (Elder elder : elders) {
                // before infection
                elder.tryAvoidPhysicalContact();
                elder.tryVaccinate();

                //infection
                virus.infect(elder);

                // after infection
                elder.tryToHeal();
                elder.tryDie();
            }
        }

        Results.printResults();
    }

    public static ArrayList<Child> getChildren(int n) {
        ArrayList<Child> children = new ArrayList<Child>();

        for (int i = 0; i < n; i++) {
            String name = ProjectUtils.generateName();
            Child child = new Child(name);
            children.add(child);
        }

        return children;
    }

    public static ArrayList<Adult> getAdults(int n) {
        ArrayList<Adult> adults = new ArrayList<Adult>();

        for (int i = 0; i < n; i++) {
            String name = ProjectUtils.generateName();
            Adult adult = new Adult(name);
            adults.add(adult);
        }

        return adults;
    }

    public static ArrayList<Elder> getElders(int n) {
        ArrayList<Elder> elders = new ArrayList<Elder>();

        for (int i = 0; i < n; i++) {
            String name = ProjectUtils.generateName();
            Elder elder = new Elder(name);
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