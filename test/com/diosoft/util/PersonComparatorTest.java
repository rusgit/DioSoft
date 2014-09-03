package com.diosoft.util;

import com.diosoft.domain.Person;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PersonComparatorTest {

    @Test
    public void testCompare() {

        Person obj1 = new Person.Builder().name("Ruslan").lastName("Borisov").age(25).post(Person.Post.DEVELOPER).build();
        Person obj2 = new Person.Builder().name("Anton").lastName("Zemlyankin").age(22).post(Person.Post.DEVELOPER).build();
        int expected = 1;

        PersonComparator personComparator = new PersonComparator();
        int actual = personComparator.compare(obj1,obj2);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompare_withFirstNull() {

        Person obj1 = null;
        Person obj2 = new Person.Builder().name("Anton").lastName("Zemlyankin").age(22).post(Person.Post.DEVELOPER).build();
        int expected = 1;

        PersonComparator personComparator = new PersonComparator();
        int actual = personComparator.compare(obj1,obj2);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompare_withSecondNull() {

        Person obj1 = new Person.Builder().name("Ruslan").lastName("Borisov").age(25).post(Person.Post.DEVELOPER).build();
        Person obj2 = null;
        int expected = -1;

        PersonComparator personComparator = new PersonComparator();
        int actual = personComparator.compare(obj1,obj2);

        assertEquals(expected, actual);
    }

    @Test
    public void testCompare_withDoubleNull() {

        Person obj1 = null;
        Person obj2 = null;
        int expected = 0;

        PersonComparator personComparator = new PersonComparator();
        int actual = personComparator.compare(obj1,obj2);

        assertEquals(expected, actual);
    }
}
