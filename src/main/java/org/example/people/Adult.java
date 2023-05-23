package org.example.people;

import org.example.results.Results;
import org.example.util.ProjectUtils;

public class Adult extends Child {
    private int healChance = 30;

    private int vaccinateChance = 25 ;

    private String status;

    private boolean isVaccinated;


    public Adult(String name, int healChance, int vaccinateChance, String status, boolean heartache, boolean phlegm, boolean isVaccinated) {
        super(name, healChance, status, heartache, phlegm);
        this.isVaccinated = isVaccinated;
        this.vaccinateChance = vaccinateChance;
    }
    @Override
    public void tryAvoidPhysicalContact() {
        int chanceToDrawAvoidPhysicalContact = 30;
        boolean avoidedPhysicalContact = false;
        boolean avoidPhysicalContact = ProjectUtils.checkIfDoAction(chanceToDrawAvoidPhysicalContact);

        if (avoidPhysicalContact && !avoidedPhysicalContact) {
            this.healChance += 10;
            avoidedPhysicalContact = true;
        }
    }

    public void tryVaccinate() {
        boolean vaccinate = ProjectUtils.checkIfDoAction(vaccinateChance);
        String st = getStatus();

        if (vaccinate && st == "notInfected" && !isVaccinated) {
            this.healChance += 20;
            setIsVaccinated(true);
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

    public void setIsVaccinated(boolean isVaccinated) {
        this.isVaccinated = isVaccinated;
    }

}
