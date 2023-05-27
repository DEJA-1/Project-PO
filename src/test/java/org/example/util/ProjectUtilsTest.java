package org.example.util;

import org.example.virus.Acutus;
import org.example.virus.Virolexia;
import org.example.virus.Virus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ProjectUtilsTest {
    @Test
    public void test_checkIfDoAction_returns_true() {
        int targetPercentage = 100;

        assertTrue(ProjectUtils.checkIfDoAction(targetPercentage));
    }

    @Test
    public void test_checkIfDoAction_returns_false() {
        int targetPercentage = 0;

        assertFalse(ProjectUtils.checkIfDoAction(targetPercentage));
    }

    @Test
    public void test_generateName_isRandom() {
        String name1 = ProjectUtils.generateName();
        String name2 = ProjectUtils.generateName();

        assertNotSame(name1, name2);
    }

    @Test
    public void test_generateName_isCorrectSize() {
        String name = ProjectUtils.generateName();

        assertEquals(6, name.length());
    }

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