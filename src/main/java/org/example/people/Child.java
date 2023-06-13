package org.example.people;

import org.example.results.Results;
import org.example.util.ProjectUtils;

/**
 * The type Child.
 */
public class Child {
    private String name;

    private int healChance = 25;

    private int chanceToDrawAvoidPhysicalContact = 10;

    private String status;

    private boolean heartache;

    private boolean phlegm;

    private final boolean isVaccinated = false;
    private boolean avoidedPhysicalContact = false;

    private final boolean isDead = false;

    /**
     * Instantiates a new Child.
     *
     * @param name       the name
     * @param healChance the heal chance
     * @param status     the status
     * @param heartache  the heartache
     * @param phlegm     the phlegm
     */
    public Child (String name, int healChance, String status, boolean heartache, boolean phlegm) {
        this.name = name;
        this.healChance = healChance;
        this.status = status;
        this.heartache = heartache;
        this.phlegm = phlegm;
    }


    /**
     * Try avoid physical contact.
     *
     * @param chanceToDraw the chance to draw
     */
    public void tryAvoidPhysicalContact(int chanceToDraw) {
        boolean avoidPhysicalContact = ProjectUtils.checkIfDoAction(chanceToDraw);

        if (avoidPhysicalContact && !avoidedPhysicalContact) {
            this.healChance += 10;
            avoidedPhysicalContact = true;
        }
    }

    /**
     * Try to heal.
     *
     * @param healChance the heal chance
     */
    public void tryToHeal(int healChance) {
        boolean heal = ProjectUtils.checkIfDoAction(healChance);

        if(heal && status == "Infected") {
            setStatus("Healed");
            Results.healedCount++;
        }

    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets heal chance.
     *
     * @return the heal chance
     */
    public int getHealChance() {
        return healChance;
    }


    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Sets heartache.
     *
     * @param hasHeartache the has heartache
     */
    public void setHeartache(boolean hasHeartache) {
        this.heartache = hasHeartache;
    }

    /**
     * Gets heartache.
     *
     * @return the heartache
     */
    public boolean getHeartache() {
        return this.heartache;
    }

    /**
     * Sets phlegm.
     *
     * @param hasPhlegm the has phlegm
     */
    public void setPhlegm(boolean hasPhlegm) {
        this.phlegm = hasPhlegm;
    }

    /**
     * Gets phlegm.
     *
     * @return the phlegm
     */
    public boolean getPhlegm() {
        return this.phlegm;
    }

    /**
     * Gets is vaccinated.
     *
     * @return the is vaccinated
     */
    public boolean getIsVaccinated() {
        return this.isVaccinated;
    }

    /**
     * Gets is dead.
     *
     * @return the is dead
     */
    public boolean getIsDead() {
        return this.isDead;
    }

    /**
     * Gets chance to draw avoid physical contact.
     *
     * @return the chance to draw avoid physical contact
     */
    public int getChanceToDrawAvoidPhysicalContact() {
        return this.chanceToDrawAvoidPhysicalContact;
    }
}
