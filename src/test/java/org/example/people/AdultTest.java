package org.example.people;

import org.example.results.Results;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdultTest {
    @Test
    public void test_tryAvoidPhysicalContact_avoidsPhysicalContact() {
        Adult adult = new Adult("", 0, 0, "Infected", false, false, false);
        int chanceToDrawAvoidPhysicalContact = 100;
        int expectedHealChance = 10;

        adult.tryAvoidPhysicalContact(chanceToDrawAvoidPhysicalContact);

        assertEquals(adult.getHealChance(), expectedHealChance);
    }

    @Test
    public void test_tryAvoidPhysicalContact_doesNotAvoidPhysicalContact() {
        Adult adult = new Adult("", 0, 0, "Infected", false, false, false);
        int chanceToDrawAvoidPhysicalContact = 0;
        int expectedHealChance = 0;

        adult.tryAvoidPhysicalContact(chanceToDrawAvoidPhysicalContact);

        assertEquals(adult.getHealChance(), expectedHealChance);
    }

    @Test
    public void test_tryToHeal_heals() {
        Adult adult = new Adult("", 0, 0, "Infected", false, false, false);
        int chanceToHeal = 100;
        String expectedStatus = "Healed";

        int healedCount = Results.getHealedCount();

        adult.tryToHeal(chanceToHeal);

        assertEquals(adult.getStatus(), expectedStatus);
        assertEquals(healedCount + 1, Results.getHealedCount());
    }

    @Test
    public void test_tryToHeal_doesNotHeal_invalidStatus() {
        Adult adult = new Adult("", 0, 0, "notInfected", false, false, false);
        int chanceToHeal = 100;
        String expectedStatus = "notInfected";

        int healedCount = Results.getHealedCount();

        adult.tryToHeal(chanceToHeal);

        assertEquals(adult.getStatus(), expectedStatus);
        assertEquals(healedCount, Results.getHealedCount());
    }

    @Test
    public void test_tryToHeal_doesNotHeal_notDrawn() {
        Adult adult = new Adult("", 0, 0, "Infected", false, false, false);

        int chanceToHeal = 0;
        String expectedStatus = "Infected";

        int healedCount = Results.getHealedCount();

        adult.tryToHeal(chanceToHeal);

        assertEquals(adult.getStatus(), expectedStatus);
        assertEquals(healedCount, Results.getHealedCount());
    }

    @Test
    public void test_tryVaccinate_vaccinates() {
        Adult adult = new Adult("", 0, 0, "notInfected", false, false, false);
        int vaccinateChance = 100;

        int initialVaccinatedCount = Results.getVaccinatedCount();
        int expectedVaccinatedCount = initialVaccinatedCount + 1;

        int initialHealChance = adult.getHealChance();
        int expectedHealChance = initialHealChance + 20;

        adult.tryVaccinate(vaccinateChance);

        assertEquals(expectedHealChance, adult.getHealChance());
        assertTrue(adult.getIsVaccinated());
        assertEquals(expectedVaccinatedCount, Results.getVaccinatedCount());
    }

    @Test
    public void test_tryVaccinate_doesNotVaccinate_invalidStatus() {
        Adult adult = new Adult("", 0, 0, "Infected", false, false, false);
        int vaccinateChance = 100;

        int initialVaccinatedCount = Results.getVaccinatedCount();
        int expectedVaccinatedCount = initialVaccinatedCount;

        int initialHealChance = adult.getHealChance();
        int expectedHealChance = initialHealChance;

        adult.tryVaccinate(vaccinateChance);

        assertEquals(expectedHealChance, adult.getHealChance());
        assertFalse(adult.getIsVaccinated());
        assertEquals(expectedVaccinatedCount, Results.getVaccinatedCount());
    }

    @Test
    public void test_tryVaccinate_doesNotVaccinate_notDrawn() {
        Adult adult = new Adult("", 0, 0, "notInfected", false, false, false);
        int vaccinateChance = 0;

        int initialVaccinatedCount = Results.getVaccinatedCount();
        int expectedVaccinatedCount = initialVaccinatedCount;

        int initialHealChance = adult.getHealChance();
        int expectedHealChance = initialHealChance;

        adult.tryVaccinate(vaccinateChance);

        assertEquals(expectedHealChance, adult.getHealChance());
        assertFalse(adult.getIsVaccinated());
        assertEquals(expectedVaccinatedCount, Results.getVaccinatedCount());
    }
}
