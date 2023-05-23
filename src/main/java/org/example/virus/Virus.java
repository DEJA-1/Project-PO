package org.example.virus;

import org.example.people.Child;

public abstract class Virus {
    protected int infectionChance;

    public Virus(int infectionChance) {
        this.infectionChance = infectionChance;
    }

    abstract public void infect(Child person);
}
