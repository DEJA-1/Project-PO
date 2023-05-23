package org.example.virus;

import org.example.people.Child;
import org.example.results.Results;

public final class Virolexia extends Virus{
    public Virolexia() {
        super(80);
    }

    @Override
    public void infect(Child person) {
        //TODO - RANDOM CHANCE TO INFECT
        String personName = person.getName();
        System.out.println("Infecting " + personName + " with Virolexia...");

        person.setStatus("Infected");
        person.setPhlegm(true);

        Results.infectionCount++;
    }
}
