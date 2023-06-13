package org.example.virus;

import org.example.people.Adult;
import org.example.people.Child;
import org.example.results.Results;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type Acutus test.
 */
public class AcutusTest {


    /**
     * Test infect infects successfully.
     */
    @Test
    public void test_Infect_infectsSuccessfully() {
        Virus acutus = new Acutus(100);
        String expectedStatus = "Infected";

        Child person = new Adult("", 0, 0, "notInfected", false, false, false);

        int infectionCount = Results.getInfectionCount();

        acutus.infect(person);

        String personStatus = person.getStatus();
        Boolean personHeartache = person.getHeartache();

        assertEquals(personStatus, expectedStatus);
        assertEquals(personHeartache, true);
        assertEquals(infectionCount + 1, Results.getInfectionCount());
    }

    /**
     * Test infect does not infect.
     */
    @Test
    public void test_Infect_doesNotInfect() {
        Virus acutus = new Acutus(100);
        String expectedStatus = "Healed";

        Child person = new Adult("", 0, 0, "Healed", false, false, false);

        int infectionCount = Results.getInfectionCount();

        acutus.infect(person);

        String personStatus = person.getStatus();
        Boolean personHeartache = person.getHeartache();


        assertEquals(personStatus, expectedStatus);
        assertEquals(personHeartache, false);
        assertEquals(infectionCount, Results.getInfectionCount());

    }
}
