package org.example.people;

import org.example.results.Results;
import org.example.util.ProjectUtils;

public class Elder extends Adult{

    private int healChance = 30;

    private int vaccinateChance = 35;
    private int deathChance = 35;
    private boolean isDead = false;
    public Elder(String name, int healChance, int vaccinateChance, int deathChance, String status, boolean heartache, boolean phlegm, boolean isVaccinated, boolean isDead) {
        super(name, healChance, vaccinateChance, status, heartache, phlegm, isVaccinated);
        this.isDead = isDead;
        this.deathChance = deathChance;
    }

    public void tryDie() {
        boolean die = ProjectUtils.checkIfDoAction(deathChance);
        String st = getStatus();

        if (die && st == "Infected" && !isDead) {
            setIsDead(true);
            setStatus("Dead");
            Results.deadCount++;
        }
    }

    public boolean getIsDead() {
        return this.isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

}
