package com.diosoft;

import com.diosoft.common.Person;
import com.diosoft.service.*;
import com.diosoft.util.PersonGenerator;
import com.diosoft.util.PersonGeneratorImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.*;
import javax.xml.bind.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException {

// PERSON GENERATOR: 2 arrays
        PersonGenerator arrayGenerator = new PersonGeneratorImpl();
        Map<String,Person[]> map = arrayGenerator.createArrays(6, 4);

// ARRAYS INITIALIZATION
        Person[] firstArray = map.get("firstArray");
        Person[] secondArray = map.get("secondArray");

// COLLECTION INITIALIZATION
        List<Person> firstColl = new ArrayList<>(Arrays.asList(firstArray));
        List<Person> secondColl = new ArrayList<>(Arrays.asList(secondArray));

// SPRING CONTEXT
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/app-context.xml");
        CollectionService collectionService = (CollectionService) ctx.getBean("collectionServiceImpl");
        ArrayService arrayService = (ArrayService) ctx.getBean("arrayServiceImpl");
        PersonService personService = (PersonService) ctx.getBean("personServiceImpl");

// COLLECTION JOIN
        collectionService.jaxbInputData(firstColl,secondColl);
        collectionService.leftUnion(firstColl, secondColl);
        collectionService.merge(firstColl, secondColl);
        collectionService.innerJoin(firstColl, secondColl);
        collectionService.outerJoin(firstColl, secondColl);

// ARRAY JOIN
        arrayService.leftUnion(firstArray, secondArray);
        arrayService.merge(firstArray, secondArray);
        arrayService.innerJoin(firstArray, secondArray);
        arrayService.outerJoin(firstArray, secondArray);

// PERSON GENERATOR: more 2 collection with same last name
        List<Person>[] personsGen = arrayGenerator.createSameSurnameMore2array(5);

// PERSON OPERATIONS STANDART
        personService.getInnerAndOuterPersons(personsGen[0],personsGen[1]);
        personService.getUniquePersonsOfSameAge(25,personsGen[0],personsGen[1]);

// PERSON OPERATIONS ADVANCED
        personService.getInnerAndOuterPersons(personsGen);
        personService.getUniquePersonsOfSameAge(25,personsGen);



   }
}