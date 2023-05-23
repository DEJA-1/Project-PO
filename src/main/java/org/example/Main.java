package org.example;

import org.example.people.Adult;
import org.example.people.Child;
import org.example.people.Elder;
import org.example.virus.Acutus;
import org.example.virus.Virolexia;
import org.example.virus.Virus;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Adult adult = new Adult("Daniel");
        Child child = new Child("John");
        Elder elder = new Elder("Ezekiel");


        Virus acutus = new Acutus();
        Virus virolexia = new Virolexia();

        adult.tryAvoidPhysicalContact();
        acutus.infect(adult);
        virolexia.infect(child);
        adult.tryVaccinate();
        elder.tryVaccinate();
        elder.tryDie();
        adult.tryToHeal();


        printInfo(adult);
        printInfo(child);
        printInfo(elder);
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

    public static void runSimulation(ArrayList<Child> children, ArrayList<Elder> elders, ArrayList<Adult> adults, Virus virus, int days) {
        //TODO - RUN THE SIMULATION ITERATING days TIMES

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

    }

    public static void getChildren(int n) {
        //TODO - CREATE LIST OF CHILDREN
    }

    public static void getAdults(int n) {
        //TODO - CREATE LIST OF ADULTS
    }

    public static void getElders(int n) {
        //TODO - CREATE LIST OF ELDERS
    }

}