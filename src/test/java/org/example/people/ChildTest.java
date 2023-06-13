package org.example.people;

import org.example.results.Results;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The type Child test.
 */
public class ChildTest {

    /**
     * Test try avoid physical contact avoids physical contact.
     */
    @Test
    public void test_tryAvoidPhysicalContact_avoidsPhysicalContact() {
        Child child = new Child("", 0, "Infected", false, false);
        int chanceToDrawAvoidPhysicalContact = 100;
        int expectedHealChance = 10;

        child.tryAvoidPhysicalContact(chanceToDrawAvoidPhysicalContact);

        assertEquals(child.getHealChance(), expectedHealChance);
    }

    /**
     * Test try avoid physical contact does not avoid physical contact.
     */
    @Test
    public void test_tryAvoidPhysicalContact_doesNotAvoidPhysicalContact() {
        Child child = new Child("", 0, "Infected", false, false);
        int chanceToDrawAvoidPhysicalContact = 0;
        int expectedHealChance = 0;

        child.tryAvoidPhysicalContact(chanceToDrawAvoidPhysicalContact);

        assertEquals(child.getHealChance(), expectedHealChance);
    }

    /**
     * Test try to heal heals.
     */
    @Test
    public void test_tryToHeal_heals() {
        Child child = new Child("", 0, "Infected", false, false);
        int chanceToHeal = 100;
        String expectedStatus = "Healed";

        int healedCount = Results.getHealedCount();

        child.tryToHeal(chanceToHeal);

        assertEquals(child.getStatus(), expectedStatus);
        assertEquals(healedCount + 1, Results.getHealedCount());
    }

    /**
     * Test try to heal does not heal invalid status.
     */
    @Test
    public void test_tryToHeal_doesNotHealInvalidStatus() {
        Child child = new Child("", 0, "notInfected", false, false);
        int chanceToHeal = 100;
        String expectedStatus = "notInfected";

        int healedCount = Results.getHealedCount();

        child.tryToHeal(chanceToHeal);

        assertEquals(child.getStatus(), expectedStatus);
        assertEquals(healedCount, Results.getHealedCount());
    }

    /**
     * Test try to heal does not heal not drawn.
     */
    @Test
    public void test_tryToHeal_doesNotHealNotDrawn() {
        Child child = new Child("", 0, "Infected", false, false);

        int chanceToHeal = 0;
        String expectedStatus = "Infected";

        int healedCount = Results.getHealedCount();

        child.tryToHeal(chanceToHeal);

        assertEquals(child.getStatus(), expectedStatus);
        assertEquals(healedCount, Results.getHealedCount());
    }
}
