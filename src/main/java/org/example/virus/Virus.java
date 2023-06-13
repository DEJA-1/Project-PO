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
    protected String name;

    /**
     * Instantiates a new Virus.
     *
     * @param infectionChance the infection chance
     */
    public Virus(int infectionChance, String name) {
        this.infectionChance = infectionChance;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Infect.
     *
     * @param person the person
     */
    abstract public void infect(Child person);
}
