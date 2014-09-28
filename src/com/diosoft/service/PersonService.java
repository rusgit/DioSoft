package com.diosoft.service;

import com.diosoft.common.Person;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

//local code review (vtegza): prefer list over vargs /arrays @ 9/28/2014
public interface PersonService {

    Map<String, List<Person>> getInnerAndOuterPersons(List<Person> persons1, List<Person> persons2) throws IOException, JAXBException;

    List<Person> getUniquePersonsOfSameAge(int age, List<Person> persons1, List<Person> persons2) throws IOException, JAXBException;

    Map<String, List<Person>> getInnerAndOuterPersons(List<Person>... persons) throws IOException, JAXBException;

    List<Person> getUniquePersonsOfSameAge(int age, List<Person>... persons) throws IOException, JAXBException;
}
