package org.example.people;

import org.example.util.Util;

public class Adult extends Child {
    private String name;
    private int healChance = 30;

    private String status = "notInfected";

    private boolean heartache = false;

    private boolean phlegm = false;
    private boolean isVaccinated = false;

    private final boolean isDead = false;

    public Adult(String name) {
        super(name);
    }
    @Override
    public void tryAvoidPhysicalContact() {
        int chanceToDrawAvoidPhysicalContact = 30;
        boolean avoidPhysicalContact = Util.checkIfDoAction(chanceToDrawAvoidPhysicalContact);

        if (avoidPhysicalContact) {
            this.healChance += 10;
        }
    }

    public void tryVaccinate() {
        //TODO - RANDOM CHANCE OF VACCINATING
        this.healChance += 20;
        this.isVaccinated = true;
    }

    public int getHealChance() {
        return healChance;
    }

    @Override
    public boolean getIsVaccinated() {
        return this.isVaccinated;
    }
}
