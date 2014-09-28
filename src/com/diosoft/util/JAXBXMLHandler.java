package com.diosoft.util;

import com.diosoft.common.Person;
import com.diosoft.common.PersonAdapter;
import com.diosoft.common.PersonAdapterWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class JAXBXMLHandler {

    public static void marshal(Collection<Person> persons, File selectedFile) throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(selectedFile));
        context = JAXBContext.newInstance(PersonAdapterWrapper.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new PersonAdapterWrapper(persons), writer);
        writer.close();
    }

    public static Collection<PersonAdapter> unmarshal(File importFile) throws JAXBException {
        //local code review (vtegza): create variable in place where it is actually needed @ 9/28/2014
        PersonAdapterWrapper persons = new PersonAdapterWrapper();

        JAXBContext context = JAXBContext.newInstance(PersonAdapterWrapper.class);
        Unmarshaller um = context.createUnmarshaller();
        persons = (PersonAdapterWrapper) um.unmarshal(importFile);

        return persons.getPersons();
    }
}