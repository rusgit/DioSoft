package com.diosoft.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "persons")
public class Persons {

    @XmlElement(name = "person", type = Person.class)
    private Collection<Person> persons;

    public Persons() {}

    public Persons(Collection<Person> persons) {
        this.persons = persons;
    }

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
    }
}

