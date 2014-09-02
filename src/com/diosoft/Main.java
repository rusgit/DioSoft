package com.diosoft;

import com.diosoft.domain.Person;
import com.diosoft.impl.ArrayHelper;
import com.diosoft.service.ServiceArray;
import com.diosoft.service.ServiceCollection;
import com.diosoft.util.PersonComparator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person.Builder().name("Ruslan").lastName("Borisov").age(25).post(Person.Post.DEVELOPER).build();
        Person person2 = new Person.Builder().name("Anton").lastName("Zemlyankin").age(22).post(Person.Post.DEVELOPER).build();
        Person person3 = new Person.Builder().name("Ekaterina").lastName("Volkova").age(28).post(Person.Post.DEVELOPER).build();
        Person person4 = new Person.Builder().name("Illya").lastName("Pinchuk").age(20).post(Person.Post.QA).build();
        Person person5 = new Person.Builder().name("Elena").lastName("Kirichenko").age(30).post(Person.Post.QA).build();
        Person person6 = new Person.Builder().name("Vladimir").lastName("Kudyna").age(35).post(Person.Post.QA).build();
        Person person7 = new Person.Builder().name("Vitaliy").lastName("Bondar").age(31).post(Person.Post.QA).build();
        Person person8 = new Person.Builder().name("Violete").lastName("Egorova").age(40).post(Person.Post.DIRECTOR).build();
        Person person9 = new Person.Builder().name("Svyatoslav").lastName("Drobich").age(45).post(Person.Post.DIRECTOR).build();
        Person person10 = new Person.Builder().name("Svetlana").lastName("Mirnaya").age(50).post(Person.Post.DIRECTOR).build();
// Create Duplicate
        Person person1_dupl = new Person.Builder(person1).build();
        Person person3_dupl = new Person.Builder(person3).build();
        Person person6_dupl = new Person.Builder(person6).build();
        Person person9_dupl = new Person.Builder(person9).build();

// Arrays initialization
        Person[] firstArray = {person5, person1, person1, person6, person3, person4, person2};
        Person[] secondArray = {person3_dupl, person8, person7, person9, person9_dupl, person1_dupl, person6_dupl, person10};
// Collections initialization
        List<Person> firstColl = new ArrayList<Person>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<Person>(Arrays.asList(secondArray));

// Equals and '==' POJO instance
        System.out.println("  >>> Equals and '==' POJO instance:\n");

        System.out.println("1. Person1 equals Person1_dupl. Result: " + person1.equals(person1_dupl));
        System.out.println("2. Person1 equals Person2. Result: " + person1.equals(person2));
        System.out.println("3. Person1 == Person1_dupl. Result: " + (person1 == person1_dupl));
        System.out.println("4. Person1 == Person2. Result: " + (person1 == person2));

// Compare POJO instance
        System.out.println("\n    >>> Compare POJO instance:\n");

        System.out.println("1. Person1 compare Person1_dupl. Result: " + person1.compareTo(person1_dupl));
        System.out.println("2. Person1 compare Person2. Result: " + person1.compareTo(person2));

// Print and compare arrays of POJO instance
        System.out.println("\n    >>> Print and compare array of POJO instance\n");

        System.out.println("      First array:\n");
        System.out.println(Arrays.toString(firstArray));
        System.out.println("      Second array:\n");
        System.out.println(Arrays.toString(secondArray));
        System.out.println("\n   Compare First array and Second array: " + Arrays.equals(firstArray, secondArray));
        Arrays.sort(firstArray, new PersonComparator());
        PersonComparator ps = new PersonComparator();
        System.out.println(ps.compare(person1, person2));

        System.out.println("\n   Compare First array and Second array: " + Arrays.equals(firstArray, secondArray));



        ApplicationContext ctx = new ClassPathXmlApplicationContext("/app-context.xml");
        ServiceCollection serviceCollection = (ServiceCollection) ctx.getBean("serviceCollection");
        ServiceArray serviceArray = (ServiceArray) ctx.getBean("serviceArray");


// LEFT UNION (COLLECTION IMPLEMENTATION)
        System.out.println("\n  >>> LEFT UNION: \n");
        List<Person> list = serviceCollection.leftUnion(firstColl, secondColl);
// MERGE (COLLECTION IMPLEMENTATION)
        System.out.println("\n  >>> MERGE (without duplicate): \n");
        Set<Person> set = serviceCollection.merge(firstColl, secondColl);

// INNER JOIN (COLLECTION IMPLEMENTATION)
        System.out.println("  >>> INNER JOIN: \n");
        Set<Person> set2 = serviceCollection.innerJoin(firstColl, secondColl);
// OUTER JOIN (COLLECTION IMPLEMENTATION)
        System.out.println("  >>> OUTER JOIN: \n");
        List<Person> list2 = serviceCollection.outerJoin(firstColl, secondColl);

// LEFT UNION (ARRAY IMPLEMENTATION)
        System.out.println("\n  >>> LEFT UNION: \n");
        Person[] array = serviceArray.leftUnion(firstArray, secondArray);
// MERGE (ARRAY IMPLEMENTATION)
        System.out.println("\n  >>> MERGE (without duplicate): \n");
        Person[] array2 = serviceArray.merge(firstArray, secondArray);
// INNER JOIN (ARRAY IMPLEMENTATION)
        System.out.println("  >>> INNER JOIN: \n");
        Person[] array3 = serviceArray.innerJoin(firstArray, secondArray);
// OUTER JOIN (ARRAY IMPLEMENTATION)
        System.out.println("  >>> OUTER JOIN: \n");
        Person[] array4 = serviceArray.outerJoin(firstArray, secondArray);


        System.out.println("BOOLEAN: " +list.containsAll(Arrays.asList(array)));
        System.out.println("BOOLEAN: " +set.containsAll(Arrays.asList(array2)));
        System.out.println("BOOLEAN: " +set2.containsAll(Arrays.asList(array3)));
        System.out.println("BOOLEAN: " +list2.containsAll(Arrays.asList(array4)));
    }
}