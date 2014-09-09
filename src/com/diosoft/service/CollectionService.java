package com.diosoft.service;

import com.diosoft.common.Person;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CollectionService {

    Set<Person> merge(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException;

    List<Person> leftUnion(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException;

    Set<Person> innerJoin(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException;

    List<Person> outerJoin(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException;

    void jaxbInputData(List<Person> firstColl, List<Person> secondColl) throws IOException, JAXBException;
}