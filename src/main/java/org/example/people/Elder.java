package org.example.people;

import org.example.results.Results;
import org.example.util.Util;

public class Elder extends Adult{
    private String name;
    private int healChance = 30;

    private int vaccinateChance = 40;

    private int deathChance = 35;

    private String status = "notInfected";

    private boolean heartache = false;

    private boolean phlegm = false;

    private boolean isVaccinated = false;
    private boolean isDead = false;
    public Elder(String name) {
        super(name);
    }

    @Override
    public void tryAvoidPhysicalContact() {
        int chanceToDrawAvoidPhysicalContact = 50;
        boolean avoidPhysicalContact = Util.checkIfDoAction(chanceToDrawAvoidPhysicalContact);

        if (avoidPhysicalContact) {
            this.healChance += 10;
        }
    }

    public void tryDie() {
        boolean die = Util.checkIfDoAction(deathChance);

        if (die) {
            this.isDead = true;
            Results.deadCount++;
        }
    }

    public boolean getIsDead() {
        return this.isDead;
    }


}
