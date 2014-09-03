package com.diosoft;

import com.diosoft.domain.Person;
import com.diosoft.service.ArrayService;
import com.diosoft.service.CollectionService;
import com.diosoft.util.PersonComparator;
import com.diosoft.util.PersonGenerator;
import com.diosoft.util.ServiceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class Main {

    public static void main(String[] args) {

// Generator initialization
        PersonGenerator pc = new PersonGenerator();
        Map<String,Person[]> map = pc.createArraysWithOutDupl(5,5);

// Arrays initialization
        Person[] firstArray = map.get("firstArray");
        Person[] secondArray = map.get("secondArray");

// Collections initialization
        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));

// SPRING CONTEXT
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/app-context.xml");
        CollectionService serviceCollection = (CollectionService) ctx.getBean("serviceCollection");
        ArrayService serviceArray = (ArrayService) ctx.getBean("serviceArray");

// FACTORY (ALTERNATIVE WAY)
//        CollectionService collectionService =  ServiceFactory.CollectionServiceFactory.create();
//        ArrayService arrayService = ServiceFactory.ArrayServiceFactory.create();


// LEFT UNION (COLLECTION IMPLEMENTATION)
        System.out.println("\n  >>> LEFT UNION: \n");
        serviceCollection.leftUnion(firstColl, secondColl);
// MERGE (COLLECTION IMPLEMENTATION)
        System.out.println("\n  >>> MERGE (without duplicate): \n");
        serviceCollection.merge(firstColl, secondColl);

// INNER JOIN (COLLECTION IMPLEMENTATION)
        System.out.println("  >>> INNER JOIN: \n");
        serviceCollection.innerJoin(firstColl, secondColl);
// OUTER JOIN (COLLECTION IMPLEMENTATION)
        System.out.println("  >>> OUTER JOIN: \n");
        serviceCollection.outerJoin(firstColl, secondColl);

// LEFT UNION (ARRAY IMPLEMENTATION)
        System.out.println("\n  >>> LEFT UNION: \n");
        serviceArray.leftUnion(firstArray, secondArray);
// MERGE (ARRAY IMPLEMENTATION)
        System.out.println("\n  >>> MERGE (without duplicate): \n");
        serviceArray.merge(firstArray, secondArray);
// INNER JOIN (ARRAY IMPLEMENTATION)
        System.out.println("  >>> INNER JOIN: \n");
        serviceArray.innerJoin(firstArray, secondArray);
// OUTER JOIN (ARRAY IMPLEMENTATION)
        System.out.println("  >>> OUTER JOIN: \n");
        serviceArray.outerJoin(firstArray, secondArray);



        Map<String,Person[]> mapDupl = pc.createArraysWithDupl(10,10,3,3);

        System.out.println(" \n \n  >>> TEST GENERATOR UNIQ \n");
        System.out.println(Arrays.toString(map.get("firstArray")));
        System.out.println(Arrays.toString(map.get("secondArray")));

        System.out.println(" \n \n  >>> TEST GENERATOR DUPL \n");
        System.out.println(Arrays.toString(mapDupl.get("firstArray")));
        System.out.println(Arrays.toString(mapDupl.get("secondArray")));

   }
}