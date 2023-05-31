package org.example;

import org.example.people.Adult;
import org.example.people.Child;
import org.example.people.Elder;
import org.example.results.Results;
import org.example.virus.Virus;

import java.util.ArrayList;
import java.util.HashMap;

import static org.example.util.ProjectUtils.*;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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

    /**
     * Run simulation.
     *
     * @param children the children
     * @param adults   the adults
     * @param elders   the elders
     * @param virus    the virus
     * @param days     the days
     * @param results  the results
     */

    public static void runSimulation(ArrayList<Child> children, ArrayList<Adult> adults, ArrayList<Elder> elders , Virus virus, int days, Results results) {
        for (int i = 0; i < days; i++) {

            for (Child child : children) {
                // before infection
                child.tryAvoidPhysicalContact(child.getChanceToDrawAvoidPhysicalContact());

                // infection
                String st = child.getStatus();
                if (st == "notInfected") {
                    virus.infect(child);
                }

                // after infection
                child.tryToHeal(child.getHealChance());
                printInfo(child);
            }

            for (Adult adult : adults) {
                // before infection
                adult.tryAvoidPhysicalContact(adult.getChanceToDrawAvoidPhysicalContact());
                adult.tryVaccinate(adult.getVaccinateChance());

                // infection
                String st = adult.getStatus();
                if (st == "notInfected") {
                    virus.infect(adult);
                }

                // after infection
                adult.tryToHeal(adult.getHealChance());
                printInfo(adult);
            }

            for (Elder elder : elders) {
                boolean isDead = elder.getIsDead();
                if (!isDead) {
                    // before infection
                    elder.tryAvoidPhysicalContact(elder.getChanceToDrawAvoidPhysicalContact());
                    elder.tryVaccinate(elder.getVaccinateChance());

                    //infection
                    String st = elder.getStatus();
                    if (st == "notInfected") {
                        virus.infect(elder);
                    }
                    // after infection
                    elder.tryToHeal(elder.getHealChance());
                    elder.tryDie(elder.getDeathChance());
                }

                printInfo(elder);
            }
        }

        results.printResults();
    }



}