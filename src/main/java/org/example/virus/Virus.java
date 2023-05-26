package org.example.virus;

import org.example.people.Child;

/**
 * The type Virus.
 */
public abstract class Virus {
    /**
     * The Infection chance.
     */
    protected int infectionChance;

    /**
     * Instantiates a new Virus.
     *
     * @param infectionChance the infection chance
     */
    public Virus(int infectionChance) {
        this.infectionChance = infectionChance;
    }

    /**
     * Infect.
     *
     * @param person the person
     */
    abstract public void infect(Child person);
}
