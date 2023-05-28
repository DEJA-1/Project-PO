package org.example.people;

import org.example.results.Results;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * The type Elder test.
 */
public class ElderTest {

    /**
     * Test try avoid physical contact avoids physical contact.
     */
    @Test
    public void test_tryAvoidPhysicalContact_avoidsPhysicalContact() {
        Elder elder = new Elder("", 0, 0, 0, "Infected", false, false, false, false);
        int chanceToDrawAvoidPhysicalContact = 100;

        int initialHealChance = elder.getHealChance();
        int expectedHealChance = initialHealChance + 10;

        elder.tryAvoidPhysicalContact(chanceToDrawAvoidPhysicalContact);

        assertEquals(elder.getHealChance(), expectedHealChance);
    }

    /**
     * Test try avoid physical contact does not avoid physical contact.
     */
    @Test
    public void test_tryAvoidPhysicalContact_doesNotAvoidPhysicalContact() {
        Elder elder = new Elder("", 0, 0, 0, "Infected", false, false, false, false);

        int chanceToDrawAvoidPhysicalContact = 0;

        int initialHealChance = elder.getHealChance();
        int expectedHealChance = initialHealChance;

        elder.tryAvoidPhysicalContact(chanceToDrawAvoidPhysicalContact);

        assertEquals(elder.getHealChance(), expectedHealChance);
    }

    /**
     * Test try to heal heals.
     */
    @Test
    public void test_tryToHeal_heals() {
        Elder elder = new Elder("", 0, 0, 0, "Infected", false, false, false, false);

        int chanceToHeal = 100;
        String expectedStatus = "Healed";

        int initialHealedCount = Results.getHealedCount();
        int expectedHealedCount = initialHealedCount + 1;

        elder.tryToHeal(chanceToHeal);

        assertEquals(elder.getStatus(), expectedStatus);
        assertEquals(expectedHealedCount, Results.getHealedCount());
    }

    /**
     * Test try to heal does not heal invalid status.
     */
    @Test
    public void test_tryToHeal_doesNotHeal_invalidStatus() {
        Elder elder = new Elder("", 0, 0, 0, "notInfected", false, false, false, false);

        int chanceToHeal = 100;
        String expectedStatus = "notInfected";

        int initialHealedCount = Results.getHealedCount();
        int expectedHealedCount = initialHealedCount;

        elder.tryToHeal(chanceToHeal);

        assertEquals(elder.getStatus(), expectedStatus);
        assertEquals(expectedHealedCount, Results.getHealedCount());
    }

    /**
     * Test try to heal does not heal not drawn.
     */
    @Test
    public void test_tryToHeal_doesNotHeal_notDrawn() {
        Elder elder = new Elder("", 0, 0, 0, "Infected", false, false, false, false);

        int chanceToHeal = 0;
        String expectedStatus = "Infected";

        int initialHealedCount = Results.getHealedCount();
        int expectedHealedCount = initialHealedCount;

        elder.tryToHeal(chanceToHeal);

        assertEquals(elder.getStatus(), expectedStatus);
        assertEquals(expectedHealedCount, Results.getHealedCount());
    }

    /**
     * Test try vaccinate vaccinates.
     */
    @Test
    public void test_tryVaccinate_vaccinates() {
        Elder elder = new Elder("", 0, 0, 0, "notInfected", false, false, false, false);
        int vaccinateChance = 100;

        int initialVaccinatedCount = Results.getVaccinatedCount();
        int expectedVaccinatedCount = initialVaccinatedCount + 1;

        int initialHealChance = elder.getHealChance();
        int expectedHealChance = initialHealChance + 20;

        elder.tryVaccinate(vaccinateChance);

        assertEquals(expectedHealChance, elder.getHealChance());
        assertTrue(elder.getIsVaccinated());
        assertEquals(expectedVaccinatedCount, Results.getVaccinatedCount());
    }

    /**
     * Test try vaccinate does not vaccinate invalid status.
     */
    @Test
    public void test_tryVaccinate_doesNotVaccinate_invalidStatus() {
        Elder elder = new Elder("", 0, 0, 0, "Infected", false, false, false, false);
        int vaccinateChance = 100;

        int initialVaccinatedCount = Results.getVaccinatedCount();
        int expectedVaccinatedCount = initialVaccinatedCount;

        int initialHealChance = elder.getHealChance();
        int expectedHealChance = initialHealChance;

        elder.tryVaccinate(vaccinateChance);

        assertEquals(expectedHealChance, elder.getHealChance());
        assertFalse(elder.getIsVaccinated());
        assertEquals(expectedVaccinatedCount, Results.getVaccinatedCount());
    }

    /**
     * Test try vaccinate does not vaccinate not drawn.
     */
    @Test
    public void test_tryVaccinate_doesNotVaccinate_notDrawn() {
        Elder elder = new Elder("", 0, 0, 0, "Infected", false, false, false, false);
        int vaccinateChance = 0;

        int initialVaccinatedCount = Results.getVaccinatedCount();
        int expectedVaccinatedCount = initialVaccinatedCount;

        int initialHealChance = elder.getHealChance();
        int expectedHealChance = initialHealChance;

        elder.tryVaccinate(vaccinateChance);

        assertEquals(expectedHealChance, elder.getHealChance());
        assertFalse(elder.getIsVaccinated());
        assertEquals(expectedVaccinatedCount, Results.getVaccinatedCount());
    }

    /**
     * Test try die dies.
     */
    @Test
    public void test_tryDie_dies() {
        Elder elder = new Elder("", 0, 0, 0, "Infected", false, false, false, false);
        int deathChance = 100;
        String expectedStatus = "Dead";

        int initialDeadCount = Results.getDeadCount();
        int expectedDeadCount = initialDeadCount + 1;

        elder.tryDie(deathChance);

        assertTrue(elder.getIsDead());
        assertEquals(elder.getStatus(), expectedStatus);
        assertEquals(expectedDeadCount, Results.getDeadCount());
    }

    /**
     * Test try die does not die invalid status.
     */
    @Test
    public void test_tryDie_doesNotDie_invalidStatus() {
        Elder elder = new Elder("", 0, 0, 0, "notInfected", false, false, false, false);
        int deathChance = 100;
        String expectedStatus = "notInfected";

        int initialDeadCount = Results.getDeadCount();
        int expectedDeadCount = initialDeadCount;

        elder.tryDie(deathChance);

        assertFalse(elder.getIsDead());
        assertEquals(elder.getStatus(), expectedStatus);
        assertEquals(expectedDeadCount, Results.getDeadCount());
    }

    /**
     * Test try die does not die not drawn.
     */
    @Test
    public void test_tryDie_doesNotDie_notDrawn() {
        Elder elder = new Elder("", 0, 0, 0, "Infected", false, false, false, false);
        int deathChance = 0;
        String expectedStatus = "Infected";

        int initialDeadCount = Results.getDeadCount();
        int expectedDeadCount = initialDeadCount;

        elder.tryDie(deathChance);

        assertFalse(elder.getIsDead());
        assertEquals(elder.getStatus(), expectedStatus);
        assertEquals(expectedDeadCount, Results.getDeadCount());
    }

}
