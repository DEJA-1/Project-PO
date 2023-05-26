package org.example.util;

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
    public void test_generateName_correctSize() {
        String name = ProjectUtils.generateName();

        assertEquals(6, name.length());
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
}