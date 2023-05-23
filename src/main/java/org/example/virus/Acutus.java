package org.example.virus;

import org.example.people.Child;
import org.example.results.Results;

public final class Acutus extends Virus{
    public Acutus() {
        super(50);
    }

    @Override
    public void infect(Child person) {
        //TODO - RANDOM CHANCE TO INFECT
        String personName = person.getName();
        System.out.println("Infecting " + personName + " with Acutus...");

        person.setStatus("Infected");
        person.setHeartache(true);

        Results.infectionCount++;
    }
}
