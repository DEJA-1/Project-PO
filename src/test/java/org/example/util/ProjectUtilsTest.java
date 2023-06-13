package org.example.util;

import org.example.people.Adult;
import org.example.people.Child;
import org.example.people.Elder;
import org.example.virus.Acutus;
import org.example.virus.Virolexia;
import org.example.virus.Virus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * The type Project utils test.
 */
@RunWith(JUnit4.class)
public class ProjectUtilsTest {
    /**
     * Test check if do action returns true.
     */
    @Test
    public void test_checkIfDoAction_returns_true() {
        int targetPercentage = 100;

        assertTrue(ProjectUtils.checkIfDoAction(targetPercentage));
    }

    /**
     * Test check if do action returns false.
     */
    @Test
    public void test_checkIfDoAction_returns_false() {
        int targetPercentage = 0;

        assertFalse(ProjectUtils.checkIfDoAction(targetPercentage));
    }

    /**
     * Test generate name is random.
     */
    @Test
    public void test_generateName_isRandom() {
        String name1 = ProjectUtils.generateName();
        String name2 = ProjectUtils.generateName();

        assertNotSame(name1, name2);
    }

    /**
     * Test generate name is correct size.
     */
    @Test
    public void test_generateName_isCorrectSize() {
        String name = ProjectUtils.generateName();

        assertEquals(6, name.length());
    }

    /**
     * Test get input data.
     */
    @Test
    public void test_getInputData() {
        String dataTypeChildren = "children";
        String dataTypeAdults = "adults";
        String dataTypeElders = "elders";
        String dataTypeDays = "days";
        String dataTypeVirus = "virus";
        Virus virus = new Acutus(50);

        String inputChildren = "2";
        String inputAdults = "3";
        String inputElders = "4";
        String inputDays = "5";
        String inputVirus = "1";
        HashMap<String, Object> data = new HashMap<>();

        InputStream inputStreamChildren = new ByteArrayInputStream(inputChildren.getBytes());
        InputStream inputStreamAdults = new ByteArrayInputStream(inputAdults.getBytes());
        InputStream inputStreamElders = new ByteArrayInputStream(inputElders.getBytes());
        InputStream inputStreamDays = new ByteArrayInputStream(inputDays.getBytes());
        InputStream inputStreamVirus = new ByteArrayInputStream(inputVirus.getBytes());

        System.setIn(inputStreamChildren);
        ProjectUtils.getData(new Scanner(System.in), data, dataTypeChildren);

        System.setIn(inputStreamAdults);
        ProjectUtils.getData(new Scanner(System.in), data, dataTypeAdults);

        System.setIn(inputStreamElders);
        ProjectUtils.getData(new Scanner(System.in), data, dataTypeElders);

        System.setIn(inputStreamDays);
        ProjectUtils.getData(new Scanner(System.in), data, dataTypeDays);

        System.setIn(inputStreamVirus);
        ProjectUtils.getVirus(new Scanner(System.in), data);

        assertEquals(Integer.parseInt(inputChildren), data.get(dataTypeChildren));
        assertEquals(Integer.parseInt(inputAdults), data.get(dataTypeAdults));
        assertEquals(Integer.parseInt(inputElders), data.get(dataTypeElders));
        assertEquals(Integer.parseInt(inputDays), data.get(dataTypeDays));
        assertEquals(virus.getClass(), data.get(dataTypeVirus).getClass());
    }

    /**
     * Test get data.
     */
    @Test
    public void test_getData() {
        String dataType = "children";
        String input = "5";
        HashMap<String, Object> data = new HashMap<>();

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Scanner scanner = new Scanner(System.in);

        ProjectUtils.getData(scanner, data, dataType);

        assertEquals(Integer.parseInt(input), data.get(dataType));
    }

    /**
     * Test get children.
     */
    @Test
    public void test_getChildren() {
        int n = 10;
        ArrayList<Child> children = ProjectUtils.getChildren(n);

        assertEquals(children.size(), n);

        for (int i = 0; i < n; i++) {
            assertTrue(children.get(i) instanceof Child);
        }
    }

    /**
     * Test get adults.
     */
    @Test
    public void test_getAdults() {
        int n = 10;
        ArrayList<Adult> adults = ProjectUtils.getAdults(n);

        assertEquals(adults.size(), n);

        for (int i = 0; i < n; i++) {
            assertTrue(adults.get(i) instanceof Adult);
        }
    }

    /**
     * Test get elders.
     */
    @Test
    public void test_getElders() {
        int n = 10;
        ArrayList<Elder> elders = ProjectUtils.getElders(n);

        assertEquals(elders.size(), n);

        for (int i = 0; i < n; i++) {
            assertTrue(elders.get(i) instanceof Elder);
        }
    }

    /**
     * Test get virus choose acutus.
     */
    @Test
    public void test_getVirus_chooseAcutus() {
        String dataType = "virus";
        Virus virus = new Acutus(50);
        String input = "1";
        HashMap<String, Object> data = new HashMap<>();

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Scanner scanner = new Scanner(System.in);

        ProjectUtils.getVirus(scanner, data);

        assertEquals(virus.getClass(), data.get(dataType).getClass());
    }

    /**
     * Test get virus choose virolexia.
     */
    @Test
    public void test_getVirus_chooseVirolexia() {
        String dataType = "virus";
        Virus virus = new Virolexia(80);
        String input = "2";
        HashMap<String, Object> data = new HashMap<>();

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Scanner scanner = new Scanner(System.in);

        ProjectUtils.getVirus(scanner, data);

        assertEquals(virus.getClass(), data.get(dataType).getClass());
    }
}