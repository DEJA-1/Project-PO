package org.example.virus;

import org.example.people.Adult;
import org.example.people.Child;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VirolexiaTest {

    @Test
    public void test_Infect_infectsSuccessfully() {
        Virus virolexia = new Virolexia(100);
        String expectedStatus = "Infected";

        Child person = new Adult("", 0, 0, "notInfected", false, false, false);

        virolexia.infect(person);

        String personStatus = person.getStatus();
        Boolean personPhlegm = person.getPhlegm();

        assertEquals(personStatus, expectedStatus);
        assertEquals(personPhlegm, true);
    }

    @Test
    public void test_Infect_doesNotInfect() {
        Virus virolexia = new Virolexia(100);
        String expectedStatus = "Healed";

        Child person = new Adult("", 0, 0, "Healed", false, false, false);

        virolexia.infect(person);

        String personStatus = person.getStatus();
        Boolean personPhlegm = person.getPhlegm();

        assertEquals(personStatus, expectedStatus);
        assertEquals(personPhlegm, false);
    }
}
