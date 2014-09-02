package com.diosoft.impl;

import com.diosoft.domain.Person;
import com.diosoft.util.PersonComparator;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollectionHelperTest {

    private Person person1 = new Person.Builder().name("Ruslan").lastName("Borisov").age(25).post(Person.Post.DEVELOPER).build();
    private Person person2 = new Person.Builder().name("Anton").lastName("Zemlyankin").age(22).post(Person.Post.DEVELOPER).build();
    private Person person3 = new Person.Builder().name("Ekaterina").lastName("Volkova").age(28).post(Person.Post.DEVELOPER).build();
    private Person person4 = new Person.Builder().name("Illya").lastName("Pinchuk").age(20).post(Person.Post.QA).build();
    private Person person5 = new Person.Builder().name("Elena").lastName("Kirichenko").age(30).post(Person.Post.QA).build();
    private Person person6 = new Person.Builder().name("Vladimir").lastName("Kudyna").age(35).post(Person.Post.QA).build();
    private Person person7 = new Person.Builder().name("Vitaliy").lastName("Bondar").age(31).post(Person.Post.QA).build();
    private Person person8 = new Person.Builder().name("Violete").lastName("Egorova").age(40).post(Person.Post.DIRECTOR).build();
    private Person person9 = new Person.Builder().name("Svyatoslav").lastName("Drobich").age(45).post(Person.Post.DIRECTOR).build();
    private Person person10 = new Person.Builder().name("Svetlana").lastName("Mirnaya").age(50).post(Person.Post.DIRECTOR).build();
    // Create Duplicate
    private Person person1_dupl = new Person.Builder(person1).build();
    private Person person3_dupl = new Person.Builder(person3).build();
    private Person person6_dupl = new Person.Builder(person6).build();
    private Person person9_dupl = new Person.Builder(person9).build();

    @Test
    public void testLeftUnion() throws Exception {

        Person[] firstArray = {person1, person4, person3, person5};
        Person[] secondArray = {person1, person2, person3, person6, person7, person4};
        Person[] expectedArray = {person1, person4, person3, person5, person1, person4, person3};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        List<Person> expectedColl = new ArrayList<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        List<Person> actualColl = ch.leftUnion(firstColl,secondColl);

        Collections.sort(expectedColl, new PersonComparator());
        Collections.sort(actualColl, new PersonComparator());

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testLeftUnion_WithNullfirstArray() throws Exception {

        Person[] secondArray = {person1, person3, person2};
        Person[] expectedArray = {};

        List<Person> firstColl = null;
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        List<Person> expectedColl = new ArrayList<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        List<Person> actualColl = ch.leftUnion(firstColl,secondColl);

        Collections.sort(expectedColl, new PersonComparator());
        Collections.sort(actualColl, new PersonComparator());

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testLeftUnion_WithNullsecondArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] expectedArray = {person1, person3, person2};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = null;
        List<Person> expectedColl = new ArrayList<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        List<Person> actualColl = ch.leftUnion(firstColl,secondColl);

        Collections.sort(expectedColl, new PersonComparator());
        Collections.sort(actualColl, new PersonComparator());

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testLeftUnion_WithEmptyfirstArray() throws Exception {

        Person[] firstArray = {};
        Person[] secondArray = {person1, person3, person2, person10};
        Person[] expectedArray = {};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        List<Person> expectedColl = new ArrayList<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        List<Person> actualColl = ch.leftUnion(firstColl,secondColl);

        Collections.sort(expectedColl, new PersonComparator());
        Collections.sort(actualColl, new PersonComparator());

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testLeftUnion_WithEmptysecondArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person10};
        Person[] secondArray = {};
        Person[] expectedArray = {person1, person3, person2, person10};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        List<Person> expectedColl = new ArrayList<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        List<Person> actualColl = ch.leftUnion(firstColl,secondColl);

        Collections.sort(expectedColl, new PersonComparator());
        Collections.sort(actualColl, new PersonComparator());

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testLeftUnion_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person10, person3, person2, person1, person3_dupl};
        Person[] expectedArray = {person1, person3, person2, person1_dupl, person3_dupl, person3, person2, person1, person3_dupl};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        List<Person> expectedColl = new ArrayList<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        List<Person> actualColl = ch.leftUnion(firstColl,secondColl);

        Collections.sort(expectedColl, new PersonComparator());
        Collections.sort(actualColl, new PersonComparator());

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testMerge() throws Exception {

        Person[] firstArray = {person1, person4, person3, person5};
        Person[] secondArray = {person1, person2, person3, person6, person7, person4};
        Person[] expectedArray = {person1, person2, person3, person4, person5, person6, person7};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        Set<Person> expectedColl = new TreeSet<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        Set<Person> actualColl = ch.merge(firstColl,secondColl);

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testMerge_WithNullArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] expectedArray = {person1, person3, person2};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = null;
        Set<Person> expectedColl = new TreeSet<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        Set<Person> actualColl = ch.merge(firstColl,secondColl);

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testMerge_WithEmptyArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person10};
        Person[] secondArray = {};
        Person[] expectedArray = {person1, person3, person2, person10};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        Set<Person> expectedColl = new TreeSet<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        Set<Person> actualColl = ch.merge(firstColl,secondColl);

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testMerge_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person10, person3, person2, person1, person3_dupl};
        Person[] expectedArray = {person1, person3, person2, person10};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        Set<Person> expectedColl = new TreeSet<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        Set<Person> actualColl = ch.merge(firstColl,secondColl);

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testInnerJoin() throws Exception {

        Person[] firstArray = {person5, person1, person6, person3, person10};
        Person[] secondArray = {person10, person4, person1, person4, person7};
        Person[] expectedArray = {person1, person10};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        Set<Person> expectedColl = new TreeSet<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        Set<Person> actualColl = ch.innerJoin(firstColl,secondColl);

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testInnerJoin_WithNullArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] expectedArray = {};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = null;
        Set<Person> expectedColl = new TreeSet<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        Set<Person> actualColl = ch.innerJoin(firstColl,secondColl);

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testInnerJoin_WithEmptyArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = {};
        Person[] expectedArray = {};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        Set<Person> expectedColl = new TreeSet<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        Set<Person> actualColl = ch.innerJoin(firstColl,secondColl);

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testInnerJoin_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person1, person3, person6 ,person6_dupl,};
        Person[] expectedArray = {person1, person3};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        Set<Person> expectedColl = new TreeSet<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        Set<Person> actualColl = ch.innerJoin(firstColl,secondColl);

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testOuterJoin() throws Exception {

        Person[] firstArray = {person5, person1, person6, person3, person7, person2};
        Person[] secondArray = {person2, person4, person7};
        Person[] expectedArray = {person5, person1, person6, person3, person4};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        List<Person> expectedColl = new ArrayList<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        List<Person> actualColl = ch.outerJoin(firstColl,secondColl);

        Collections.sort(expectedColl, new PersonComparator());
        Collections.sort(actualColl, new PersonComparator());

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testOuterJoin_WithNullArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] expectedArray = {person1, person3, person2};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = null;
        List<Person> expectedColl = new ArrayList<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        List<Person> actualColl = ch.outerJoin(firstColl,secondColl);

        Collections.sort(expectedColl, new PersonComparator());
        Collections.sort(actualColl, new PersonComparator());

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testOuterJoin_WithEmptyArray() throws Exception {

        Person[] firstArray = {person1, person3, person2};
        Person[] secondArray = {};
        Person[] expectedArray = {person1, person3, person2};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        List<Person> expectedColl = new ArrayList<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        List<Person> actualColl = ch.outerJoin(firstColl,secondColl);

        Collections.sort(expectedColl, new PersonComparator());
        Collections.sort(actualColl, new PersonComparator());

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }

    @Test
    public void testOutetJoin_WithDuplicateArray() throws Exception {

        Person[] firstArray = {person1, person3, person2, person1_dupl, person3_dupl};
        Person[] secondArray = {person3, person2, person3_dupl};
        Person[] expectedArray = {person1, person1_dupl};

        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));
        List<Person> expectedColl = new ArrayList<>(Arrays.asList(expectedArray));

        CollectionHelper ch = new CollectionHelper();
        List<Person> actualColl = ch.outerJoin(firstColl,secondColl);

        Collections.sort(expectedColl, new PersonComparator());
        Collections.sort(actualColl, new PersonComparator());

        boolean result = expectedColl.equals(actualColl);
        assertTrue(result);
    }
}
