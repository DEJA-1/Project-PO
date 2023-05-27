package org.example.virus;

import org.example.people.Adult;
import org.example.people.Child;
import org.junit.Test;

import static org.junit.Assert.*;
public class AcutusTest {


    @Test
    public void test_Infect_infectsSuccessfully() {
        Virus acutus = new Acutus(100);
        String expectedStatus = "Infected";

        Child person = new Adult("", 0, 0, "notInfected", false, false, false);

        acutus.infect(person);

        String personStatus = person.getStatus();
        assertEquals(personStatus, expectedStatus);
    }

    @Test
    public void test_Infect_doesNotInfect() {
        Virus acutus = new Acutus(100);
        String expectedStatus = "Healed";

        Child person = new Adult("", 0, 0, "Healed", false, false, false);

        acutus.infect(person);

        String personStatus = person.getStatus();
        assertEquals(personStatus, expectedStatus);
    }
}
