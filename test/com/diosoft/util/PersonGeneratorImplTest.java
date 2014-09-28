package com.diosoft.util;

import com.diosoft.common.Person;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PersonGeneratorImplTest {

    @Test
    public void testCreateArrays_Size() {

        int sizeFirstArray = 5;
        int sizeSecondArray = 3;
        int expectedFirstSize = 5;
        int expectedSecondSize = 3;

        PersonGenerator ps = new PersonGeneratorImpl();
        Map<String,Person[]> map = ps.createArrays(sizeFirstArray, sizeSecondArray);
        Person[] firstArray = map.get("firstArray");
        Person[] secondArray = map.get("secondArray");

        assertTrue(expectedFirstSize==firstArray.length);
        assertTrue(expectedSecondSize==secondArray.length);
//local code review (vtegza): there is no case when it should not be an instance of Person @ 9/28/2014
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

        PersonGenerator pg = new PersonGeneratorImpl();
        Map<String,Person[]> map = pg.createArrays(sizeFirstArray, sizeSecondArray);
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

        PersonGenerator pg = new PersonGeneratorImpl();
        Map<String,Person[]> map = pg.createArrays(sizeFirstArray, sizeSecondArray);
    }

    @Test
    public void testCreateArray_WithArgMore10() {

        int sizeFirstArray = 1244;
        int sizeSecondArray = 1245;
        int expectedFirstSize = 10;
        int expectedSecondSize = 10;

        PersonGenerator pg = new PersonGeneratorImpl();
        Map<String,Person[]> map = pg.createArrays(sizeFirstArray, sizeSecondArray);
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
