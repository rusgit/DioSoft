package com.diosoft.util;

import com.diosoft.domain.Person;
import com.diosoft.domain.Persons;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBXMLHandler {

    public static void marshal(Collection<Person> persons, File selectedFile) throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(selectedFile));
        context = JAXBContext.newInstance(Persons.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new Persons(persons), writer);
        writer.close();
    }

    public static Collection<Person> unmarshal(File importFile) throws JAXBException {
        Persons persons = new Persons();

        JAXBContext context = JAXBContext.newInstance(Persons.class);
        Unmarshaller um = context.createUnmarshaller();
        persons = (Persons) um.unmarshal(importFile);

        return persons.getPersons();
    }
}