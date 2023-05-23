package org.example.people;

import org.example.results.Results;
import org.example.util.ProjectUtils;

public class Adult extends Child {
    private String name;
    private int healChance = 30;

    private int vaccinateChance = 25;

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
        boolean avoidedPhysicalContact = false;
        boolean avoidPhysicalContact = ProjectUtils.checkIfDoAction(chanceToDrawAvoidPhysicalContact);

        if (avoidPhysicalContact && !avoidedPhysicalContact) {
            this.healChance += 10;
            avoidedPhysicalContact = true;
            System.out.println("AVOIDING PHYSICAL CONTACT");
        }
    }

    public void tryVaccinate() {
        boolean vaccinate = ProjectUtils.checkIfDoAction(vaccinateChance);

        if (vaccinate && status == "notInfected" && !isVaccinated) {
            this.healChance += 20;
            this.isVaccinated = true;
            Results.vaccinatedCount++;
        }
    }

    public int getHealChance() {
        return healChance;
    }

    @Override
    public boolean getIsVaccinated() {
        return this.isVaccinated;
    }
}
