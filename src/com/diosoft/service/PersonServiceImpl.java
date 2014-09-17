package com.diosoft.service;

import com.diosoft.common.Person;
import com.diosoft.common.PersonAdapterWrapper;
import com.diosoft.helper.PersonOperations;
import com.diosoft.util.JAXBXMLHandler;
import org.apache.log4j.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Named("personServiceImpl")
public class PersonServiceImpl implements PersonService {

    private static final Logger LOG = Logger.getLogger(PersonServiceImpl.class);

    @Inject
    private PersonOperations personOperations;

    public PersonServiceImpl(PersonOperations po) {
        this.personOperations = po;
    }

    public PersonServiceImpl() {
    }

    @Override
    public Map<String, List<Person>> getInnerAndOuterPersons(List<Person> persons1, List<Person> persons2) throws IOException, JAXBException {

        LOG.info(">>> Person Operation: getInnerAndOuterPersons ");
        LOG.info("First Collection: ");
        LOG.info(persons1);
        LOG.info("Second Collection: ");
        LOG.info(persons2);

        Map<String, List<Person>> result = personOperations.getInnerAndOuterPersons(persons1, persons2);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File innerFile = new File("resources/personOperation/inner.xml");
        JAXBXMLHandler.marshal(result.get("Inner"),innerFile);
        File outerFile = new File("resources/personOperation/outer.xml");
        JAXBXMLHandler.marshal(result.get("Outer"),outerFile);

        return result;
    }

    @Override
    public List<Person> getUniquePersonsOfSameAge(int age, List<Person> persons1, List<Person> persons2) throws IOException, JAXBException {

        LOG.info(">>> Person Operation: getUniquePersonsOfSameAge ");
        LOG.info("First Collection: ");
        LOG.info(persons1);
        LOG.info("Second Collection: ");
        LOG.info(persons2);
        LOG.info("Search by age: " + age);

        List<Person> result = personOperations.getUniquePersonsOfSameAge(age, persons1, persons2);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File someAge = new File("resources/personOperation/someAge.xml");
        JAXBXMLHandler.marshal(result,someAge);

        return result;
    }

    @Override
    public Map<String, List<Person>> getInnerAndOuterPersons(List<Person>... persons) throws IOException, JAXBException {

        LOG.info(">>> Person Operation: getInnerAndOuterPersons (Advanced) ");
        for (int i=0; i < persons.length; i++) {
            LOG.info("Collection #"+ (i+1));
            LOG.info(persons[i]);
        }

        Map<String, List<Person>> result = personOperations.getInnerAndOuterPersons(persons);

        LOG.info("Result Collection: ");
        LOG.info(result);

        File innerFileAdvanced = new File("resources/personOperation/innerAdvanced.xml");
        JAXBXMLHandler.marshal(result.get("Inner"),innerFileAdvanced);
        File outerFileAdvanced = new File("resources/personOperation/outerAdvanced.xml");
        JAXBXMLHandler.marshal(result.get("Outer"),outerFileAdvanced);

        return result;
    }

    @Override
    public List<Person> getUniquePersonsOfSameAge(int age, List<Person>... persons) throws IOException, JAXBException {
        LOG.info(">>> Person Operation: getUniquePersonsOfSameAge (Advanced) ");
        for (int i=0; i < persons.length; i++) {
            LOG.info("Collection #"+ (i+1));
            LOG.info(persons[i]);
        }
        LOG.info("Search by age: " + age);

        List<Person> result = personOperations.getUniquePersonsOfSameAge(age, persons);

        LOG.info("Result Collection: ");
        LOG.info(result);

        PersonAdapterWrapper resultAdapter = new PersonAdapterWrapper(result);

        File someAgeAdvanced = new File("resources/personOperation/someAgeAdvanced.xml");
        JAXBXMLHandler.marshal(result,someAgeAdvanced);

        return result;
    }
}
