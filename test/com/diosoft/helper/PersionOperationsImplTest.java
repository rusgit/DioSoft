package com.diosoft.helper;

import com.diosoft.common.Person;
import com.diosoft.util.PersonComparator;
import org.junit.Test;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class PersionOperationsImplTest {

    // Same surnames
    private Person person11 = new Person.Builder().id(11).name("Ekaterina").lastName("Kudyna").age(25).post(Person.Post.DEVELOPER).build();
    private Person person12 = new Person.Builder().id(12).name("Elena").lastName("Kudyna").age(22).post(Person.Post.DEVELOPER).build();
    private Person person13 = new Person.Builder().id(13).name("Svetlana").lastName("Kudyna").age(28).post(Person.Post.DEVELOPER).build();

    private Person person14 = new Person.Builder().id(14).name("Vladimir").lastName("Borisov").age(20).post(Person.Post.QA).build();
    private Person person15 = new Person.Builder().id(15).name("Svyatoslav").lastName("Borisov").age(30).post(Person.Post.QA).build();
    private Person person16 = new Person.Builder().id(16).name("Ruslan").lastName("Borisov").age(35).post(Person.Post.QA).build();

    private Person person17 = new Person.Builder().id(17).name("Vitaliy").lastName("Kirichenko").age(31).post(Person.Post.QA).build();
    private Person person18 = new Person.Builder().id(18).name("Violeta").lastName("Kirichenko").age(40).post(Person.Post.DIRECTOR).build();
    private Person person19 = new Person.Builder().id(19).name("Svyatoslav").lastName("Kirichenko").age(45).post(Person.Post.DIRECTOR).build();

    private Person person20 = new Person.Builder().id(20).name("Svetlana").lastName("Drobich").age(31).post(Person.Post.DIRECTOR).build();
    private Person person21 = new Person.Builder().id(21).name("Anton").lastName("Drobich").age(35).post(Person.Post.QA).build();
    private Person person22 = new Person.Builder().id(22).name("Vitaliy").lastName("Drobich").age(31).post(Person.Post.QA).build();

    private Person person23 = new Person.Builder().id(23).name("Ruslan").lastName("Zemlyankin").age(40).post(Person.Post.DIRECTOR).build();
    private Person person24 = new Person.Builder().id(24).name("Svyatoslav").lastName("Zemlyankin").age(45).post(Person.Post.DIRECTOR).build();
    private Person person25 = new Person.Builder().id(25).name("Vitaliy").lastName("Zemlyankin").age(50).post(Person.Post.DIRECTOR).build();

    private Person person26 = new Person.Builder().id(26).name("Ruslan").lastName("Kuch").age(40).post(Person.Post.DIRECTOR).build();
    private Person person27 = new Person.Builder().id(27).name("Svyatoslav").lastName("Kuch").age(45).post(Person.Post.DIRECTOR).build();
    private Person person28 = new Person.Builder().id(28).name("Vitaliy").lastName("Kuch").age(50).post(Person.Post.DIRECTOR).build();

    private Person person29 = new Person.Builder().id(29).name("Ruslan").lastName("Milevsky").age(40).post(Person.Post.DIRECTOR).build();
    private Person person30 = new Person.Builder().id(30).name("Svyatoslav").lastName("Milevsky").age(45).post(Person.Post.DIRECTOR).build();
    private Person person31 = new Person.Builder().id(31).name("Vitaliy").lastName("Milevsky").age(50).post(Person.Post.DIRECTOR).build();

    private Person person32 = new Person.Builder().id(32).name("Ruslan").lastName("Horoshiy").age(40).post(Person.Post.DIRECTOR).build();
    private Person person33 = new Person.Builder().id(33).name("Svyatoslav").lastName("Horoshiy").age(45).post(Person.Post.DIRECTOR).build();
    private Person person34 = new Person.Builder().id(34).name("Vitaliy").lastName("Horoshiy").age(50).post(Person.Post.DIRECTOR).build();

    private Person person35 = new Person.Builder().id(35).name("Ruslan").lastName("Volkov").age(40).post(Person.Post.DIRECTOR).build();
    private Person person36 = new Person.Builder().id(36).name("Svyatoslav").lastName("Volkov").age(45).post(Person.Post.DIRECTOR).build();
    private Person person37 = new Person.Builder().id(37).name("Vitaliy").lastName("Volkov").age(50).post(Person.Post.DIRECTOR).build();

    private Person person38 = new Person.Builder().id(38).name("Ruslan").lastName("Landushev").age(40).post(Person.Post.DIRECTOR).build();
    private Person person39 = new Person.Builder().id(39).name("Svyatoslav").lastName("Landushev").age(45).post(Person.Post.DIRECTOR).build();
    private Person person40 = new Person.Builder().id(40).name("Vitaliy").lastName("Landushev").age(50).post(Person.Post.DIRECTOR).build();


    @Test
    public void getInnerAndOuterPersons() throws IOException, JAXBException {
        Person[] personsArray1 = {person11,person14,person17,person20};
        Person[] personsArray2 = {person12,person15,person26,person29};
        Person[] expectedArrayInner = {person11,person12,person14,person15};
        Person[] expectedArrayOuter = {person17,person20,person26,person29};

        List<Person> persons1 = new ArrayList<>(Arrays.asList(personsArray1));
        List<Person> persons2 = new ArrayList<>(Arrays.asList(personsArray2));
        List<Person> expectedInner = new ArrayList<>(Arrays.asList(expectedArrayInner));
        List<Person> expectedOuter = new ArrayList<>(Arrays.asList(expectedArrayOuter));

        PersonOperations po = new PersonOperationsImpl();

        Map<String, List<Person>> resultMap = po.getInnerAndOuterPersons(persons1,persons2);

        List<Person> actaulInner = resultMap.get("Inner");
        List<Person> actaulOuter = resultMap.get("Outer");

        Collections.sort(expectedInner, new PersonComparator());
        Collections.sort(expectedOuter, new PersonComparator());
        Collections.sort(actaulInner, new PersonComparator());
        Collections.sort(actaulOuter, new PersonComparator());

        boolean resultInner = expectedInner.equals(actaulInner);
        assertTrue(resultInner);
        boolean resultOuter = expectedOuter.equals(actaulOuter);
        assertTrue(resultOuter);
    }

    @Test
    public void getUniquePersonsOfSameAge(){
        Person[] personsArray1 = {person11,person14,person17,person20};
        Person[] personsArray2 = {person12,person15,person26,person29};
        Person[] expectedArray = {person17,person20};

        List<Person> persons1 = new ArrayList<>(Arrays.asList(personsArray1));
        List<Person> persons2 = new ArrayList<>(Arrays.asList(personsArray2));
        List<Person> expected = new ArrayList<>(Arrays.asList(expectedArray));

        PersonOperations po = new PersonOperationsImpl();

        List<Person> resultList = po.getUniquePersonsOfSameAge(31,persons1,persons2);

        Collections.sort(expected, new PersonComparator());
        Collections.sort(resultList, new PersonComparator());

        boolean resultInner = expected.equals(resultList);
        assertTrue(resultInner);
    }

    @Test
    public void getInnerAndOuterPersonsMore2(){
        Person[] personsArray1 = {person11,person14,person17,person20};
        Person[] personsArray2 = {person12,person15,person26,person29};
        Person[] personsArray3 = {person27,person30,person32,person35};
        Person[] expectedArrayInner = {person11,person12,person14,person15,person26,person27,person29,person30};
        Person[] expectedArrayOuter = {person17,person20,person32,person35};

        List<Person> persons1 = new ArrayList<>(Arrays.asList(personsArray1));
        List<Person> persons2 = new ArrayList<>(Arrays.asList(personsArray2));
        List<Person> persons3 = new ArrayList<>(Arrays.asList(personsArray3));
        List<Person>[] persons = new List[]{persons1,persons2,persons3};

        List<Person> expectedInner = new ArrayList<>(Arrays.asList(expectedArrayInner));
        List<Person> expectedOuter = new ArrayList<>(Arrays.asList(expectedArrayOuter));

        PersonOperations po = new PersonOperationsImpl();

        Map<String, List<Person>> resultMap = po.getInnerAndOuterPersons(persons);

        List<Person> actaulInner = resultMap.get("Inner");
        List<Person> actaulOuter = resultMap.get("Outer");

        Collections.sort(expectedInner, new PersonComparator());
        Collections.sort(expectedOuter, new PersonComparator());
        Collections.sort(actaulInner, new PersonComparator());
        Collections.sort(actaulOuter, new PersonComparator());

        boolean resultInner = expectedInner.equals(actaulInner);
        assertTrue(resultInner);
        boolean resultOuter = expectedOuter.equals(actaulOuter);
        assertTrue(resultOuter);
    }

    @Test
    public void getUniquePersonsOfSameAgeMore2(){
        Person[] personsArray1 = {person11,person14,person17,person20};
        Person[] personsArray2 = {person12,person15,person26,person29};
        Person[] personsArray3 = {person27,person30,person32,person35};
        Person[] expectedArray = {person17,person20};

        List<Person> persons1 = new ArrayList<>(Arrays.asList(personsArray1));
        List<Person> persons2 = new ArrayList<>(Arrays.asList(personsArray2));
        List<Person> persons3 = new ArrayList<>(Arrays.asList(personsArray3));

        List<Person>[] persons = new List[]{persons1,persons2,persons3};
        List<Person> expected = new ArrayList<>(Arrays.asList(expectedArray));

        PersonOperations po = new PersonOperationsImpl();

        List<Person> resultList = po.getUniquePersonsOfSameAge(31,persons);

        Collections.sort(expected, new PersonComparator());
        Collections.sort(resultList, new PersonComparator());

        boolean resultInner = expected.equals(resultList);
        assertTrue(resultInner);
    }

}
