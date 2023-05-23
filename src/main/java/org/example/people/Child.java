package org.example.people;

import org.example.results.Results;
import org.example.util.ProjectUtils;

public class Child {
    private String name;

    private int healChance = 25;

    private String status;

    private boolean heartache;

    private boolean phlegm;

    private final boolean isVaccinated = false;

    private final boolean isDead = false;

    public Child (String name, int healChance, String status, boolean heartache, boolean phlegm) {
        this.name = name;
        this.healChance = healChance;
        this.status = status;
        this.heartache = heartache;
        this.phlegm = phlegm;
    }

    public void tryAvoidPhysicalContact() {
        int chanceToDrawAvoidPhysicalContact = 10;
        boolean avoidedPhysicalContact = false;
        boolean avoidPhysicalContact = ProjectUtils.checkIfDoAction(chanceToDrawAvoidPhysicalContact);

        if (avoidPhysicalContact && !avoidedPhysicalContact) {
            this.healChance += 10;
            avoidedPhysicalContact = true;
        }
    }

    public void tryToHeal() {
        boolean heal = ProjectUtils.checkIfDoAction(healChance);

        if(heal && status == "Infected") {
            setStatus("Healed");
            Results.healedCount++;
        }

    }

    public String getName() {
        return name;
    }

    public int getHealChance() {
        return healChance;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setHeartache(boolean hasHeartache) {
        this.heartache = hasHeartache;
    }

    public boolean getHeartache() {
        return this.heartache;
    }

    public void setPhlegm(boolean hasPhlegm) {
        this.phlegm = hasPhlegm;
    }

    public boolean getPhlegm() {
        return this.phlegm;
    }

    public boolean getIsVaccinated() {
        return this.isVaccinated;
    }

    public boolean getIsDead() {
        return this.isDead;
    }
}
