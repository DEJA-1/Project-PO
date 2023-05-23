package org.example.virus;

import org.example.people.Child;

public abstract class Virus {
    protected double infectionChance;

    public Virus(double infectionChance) {
        this.infectionChance = infectionChance;
    }

    abstract public void infect(Child person);
}
