package com.diosoft.util;

import com.diosoft.domain.Person;
import com.diosoft.interfaces.ArrayGenerator;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class PersonGeneratorTest {

    @Test
    public void testCreateArrays_Size() {

        int sizeFirstArray = 5;
        int sizeSecondArray = 3;
        int expectedFirstSize = 5;
        int expectedSecondSize = 3;

        ArrayGenerator ag = new PersonGenerator();
        Map<String,Person[]> map = ag.createArrays(sizeFirstArray, sizeSecondArray);
        Person[] firstArray = map.get("firstArray");
        Person[] secondArray = map.get("secondArray");

        assertTrue(expectedFirstSize==firstArray.length);
        assertTrue(expectedSecondSize==secondArray.length);

        for (int i=0; i<firstArray.length; i++){
            assertTrue(firstArray[i] instanceof Person);
        }
        for (int i=0; i<secondArray.length; i++){
            assertTrue(secondArray[i] instanceof Person);
        }
    }

    @Test
    public void testCreateArrays_NoDuplicate() {

        int sizeFirstArray = 5;
        int sizeSecondArray = 3;

        ArrayGenerator ag = new PersonGenerator();
        Map<String,Person[]> map = ag.createArrays(sizeFirstArray, sizeSecondArray);
        Person[] firstArray = map.get("firstArray");
        Person[] secondArray = map.get("secondArray");

        int counterUniqElem = 0;
        for (Person person1 : firstArray){
            for (Person person2 : firstArray)
                if (person1.equals(person2)) {
                counterUniqElem++;
            }
            assertTrue(counterUniqElem==1);
            counterUniqElem=0;
        }

        for (Person person1 : secondArray){
            for (Person person2 : secondArray)
                if (person1.equals(person2)) {
                    counterUniqElem++;
                }
            assertTrue(counterUniqElem==1);
            counterUniqElem=0;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateArrays_WithNegativeArg() {

        int sizeFirstArray = -3;
        int sizeSecondArray = 3;

        ArrayGenerator ag = new PersonGenerator();
        Map<String,Person[]> map = ag.createArrays(sizeFirstArray, sizeSecondArray);
    }

    @Test
    public void testCreateArray_WithArgMore10() {

        int sizeFirstArray = 1244;
        int sizeSecondArray = 1245;
        int expectedFirstSize = 10;
        int expectedSecondSize = 10;

        ArrayGenerator ag = new PersonGenerator();
        Map<String,Person[]> map = ag.createArrays(sizeFirstArray, sizeSecondArray);
        Person[] firstArray = map.get("firstArray");
        Person[] secondArray = map.get("secondArray");

        assertTrue(expectedFirstSize==firstArray.length);
        assertTrue(expectedSecondSize==secondArray.length);

        for (int i=0; i<firstArray.length; i++){
            assertTrue(firstArray[i] instanceof Person);
        }
        for (int i=0; i<secondArray.length; i++){
            assertTrue(secondArray[i] instanceof Person);
        }
    }
}
