package org.example.people;

import org.example.results.Results;
import org.example.util.ProjectUtils;

/**
 * The type Elder.
 */
public class Elder extends Adult{

    private int healChance = 30;

    private int vaccinateChance = 35;
    private int deathChance = 35;
    private boolean isDead = false;

    /**
     * Instantiates a new Elder.
     *
     * @param name            the name
     * @param healChance      the heal chance
     * @param vaccinateChance the vaccinate chance
     * @param deathChance     the death chance
     * @param status          the status
     * @param heartache       the heartache
     * @param phlegm          the phlegm
     * @param isVaccinated    the is vaccinated
     * @param isDead          the is dead
     */
    public Elder(String name, int healChance, int vaccinateChance, int deathChance, String status, boolean heartache, boolean phlegm, boolean isVaccinated, boolean isDead) {
        super(name, healChance, vaccinateChance, status, heartache, phlegm, isVaccinated);
        this.isDead = isDead;
        this.deathChance = deathChance;
    }

    /**
     * Try die.
     */
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

    /**
     * Sets is dead.
     *
     * @param isDead the is dead
     */
    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

}
