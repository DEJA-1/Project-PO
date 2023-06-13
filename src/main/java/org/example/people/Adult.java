package org.example.people;

import org.example.results.Results;
import org.example.util.ProjectUtils;

/**
 * The type Adult.
 */
public class Adult extends Child {
    private int healChance = 30;
    private final int chanceToDrawAvoidPhysicalContact = 35;

    private int vaccinateChance = 25;

    private String status;

    private boolean isVaccinated;


    /**
     * Instantiates a new Adult.
     *
     * @param name            the name
     * @param healChance      the heal chance
     * @param vaccinateChance the vaccinate chance
     * @param status          the status
     * @param heartache       the heartache
     * @param phlegm          the phlegm
     * @param isVaccinated    the is vaccinated
     */
    public Adult(String name, int healChance, int vaccinateChance, String status, boolean heartache, boolean phlegm, boolean isVaccinated) {
        super(name, healChance, status, heartache, phlegm);
        this.healChance = healChance;
        this.isVaccinated = isVaccinated;
        this.vaccinateChance = vaccinateChance;
    }

    @Override
    public void tryAvoidPhysicalContact(int chanceToDraw) {
        boolean avoidedPhysicalContact = false;
        boolean avoidPhysicalContact = ProjectUtils.checkIfDoAction(chanceToDraw);

        if (avoidPhysicalContact && !avoidedPhysicalContact) {
            this.healChance += 10;
            avoidedPhysicalContact = true;
        }
    }

    /**
     * Try vaccinate.
     *
     * @param vaccinateChance the vaccinate chance
     */
    public void tryVaccinate(int vaccinateChance) {
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

    /**
     * Sets is vaccinated.
     *
     * @param isVaccinated the is vaccinated
     */
    public void setIsVaccinated(boolean isVaccinated) {
        this.isVaccinated = isVaccinated;
    }

    /**
     * Gets vaccinate chance.
     *
     * @return the vaccinate chance
     */
    public int getVaccinateChance() {
        return this.vaccinateChance;
    }

    public int getChanceToDrawAvoidPhysicalContact() {
        return this.chanceToDrawAvoidPhysicalContact;
    }

}
