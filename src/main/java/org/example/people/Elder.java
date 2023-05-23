package org.example.people;

import org.example.results.Results;
import org.example.util.ProjectUtils;

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
    public Elder(String name, int healChance, int vaccinateChance, int deathChance, String status, boolean heartache, boolean phlegm, boolean isVaccinated, boolean isDead) {
        super(name, healChance, vaccinateChance, status, heartache, phlegm, isVaccinated);
        this.isDead = isDead;
        this.deathChance = deathChance;
    }

//    @Override
//    public void tryAvoidPhysicalContact() {
//        int chanceToDrawAvoidPhysicalContact = 50;
//        boolean avoidedPhysicalContact = false;
//        boolean avoidPhysicalContact = ProjectUtils.checkIfDoAction(chanceToDrawAvoidPhysicalContact);
//
//        if (avoidPhysicalContact && !avoidedPhysicalContact) {
//            this.healChance += 10;
//            avoidedPhysicalContact = true;
//        }
//    }

    public void tryDie() {
        boolean die = ProjectUtils.checkIfDoAction(deathChance);

        if (die && !isDead) {
            this.isDead = true;
            Results.deadCount++;
        }
    }

    public boolean getIsDead() {
        return this.isDead;
    }


}
