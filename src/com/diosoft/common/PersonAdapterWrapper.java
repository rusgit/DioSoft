package com.diosoft.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "persons")
public class PersonAdapterWrapper {

    @XmlElement(name = "person", type = PersonAdapter.class)
    private List<PersonAdapter> personsAdapter;

    public PersonAdapterWrapper() {}

    public PersonAdapterWrapper(Collection<Person> persons) {
        List<PersonAdapter> tempList = new ArrayList<PersonAdapter>();
        for (Person person: persons) {
            PersonAdapter personAdapter = new PersonAdapter(person);
            tempList.add(personAdapter);
        }
        this.personsAdapter = tempList;

    }

    public List<PersonAdapter> getPersons() {
        return personsAdapter;
    }

    public void setPersons(List<PersonAdapter> persons) {
        this.personsAdapter = persons;
    }
}

