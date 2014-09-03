package com.diosoft;

import com.diosoft.domain.Person;
import com.diosoft.interfaces.ArrayGenerator;
import com.diosoft.service.ArrayService;
import com.diosoft.service.CollectionService;
import com.diosoft.util.JAXBXMLHandler;
import com.diosoft.util.PersonGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.*;
import javax.xml.bind.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException {

// Generator initialization
        ArrayGenerator arrayGenerator = new PersonGenerator();
        Map<String,Person[]> map = arrayGenerator.createArrays(8, 6);

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

// COLLECTION IMPLEMENTATION
        serviceCollection.jaxbInputData(firstColl,secondColl);
        serviceCollection.leftUnion(firstColl, secondColl);
        serviceCollection.merge(firstColl, secondColl);
        serviceCollection.innerJoin(firstColl, secondColl);
        serviceCollection.outerJoin(firstColl, secondColl);

// ARRAY IMPLEMENTATION
//        serviceArray.leftUnion(firstArray, secondArray);
//        serviceArray.merge(firstArray, secondArray);
//        serviceArray.innerJoin(firstArray, secondArray);
//        serviceArray.outerJoin(firstArray, secondArray);

   }
}