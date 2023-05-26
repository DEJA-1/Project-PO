package org.example.virus;

import org.example.people.Child;
import org.example.results.Results;
import org.example.util.ProjectUtils;

/**
 * The type Virolexia.
 */
public final class Virolexia extends Virus{
    /**
     * Instantiates a new Virolexia.
     */
    public Virolexia() {
        super(80);
    }

    @Override
    public void infect(Child person) {
        boolean infect = ProjectUtils.checkIfDoAction(infectionChance);

        if (infect) {
            String personName = person.getName();
            System.out.println("Infecting " + personName + " with Virolexia...");

            person.setStatus("Infected");
            person.setPhlegm(true);

            Results.infectionCount++;
        }
    }
}
