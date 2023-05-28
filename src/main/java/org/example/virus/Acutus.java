package org.example.virus;

import org.example.people.Child;
import org.example.results.Results;
import org.example.util.ProjectUtils;

/**
 * The type Acutus.
 */
public final class Acutus extends Virus{
    /**
     * Instantiates a new Acutus.
     *
     * @param infectionChance the infection chance
     */
// Default infection chance = 50
    public Acutus(int infectionChance) {
        super(infectionChance);
    }

    @Override
    public void infect(Child person) {
        boolean infect = ProjectUtils.checkIfDoAction(infectionChance);
        String personStatus = person.getStatus();

        if (infect && personStatus == "notInfected") {
            String personName = person.getName();
            System.out.println("Infecting " + personName + " with Acutus...");

            person.setStatus("Infected");
            person.setHeartache(true);

            Results.infectionCount++;
        }
    }
}
