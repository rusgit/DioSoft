package com.diosoft.helper;

import com.diosoft.common.Person;
import javax.inject.Named;
import java.util.*;

@Named("personOperationsImpl")
public class PersonOperationsImpl implements PersonOperations {

    @Override
    public Map<String, List<Person>> getInnerAndOuterPersons(List<Person> persons1, List<Person> persons2) {

        Map<String, List<Person>> result = new HashMap<String, List<Person>>();

        if (getLength(persons1) == 0) {
            result.put("Inner", new ArrayList<Person>());
            result.put("Outer", persons2);
            return result;
        }

        if (getLength(persons2) == 0) {
            result.put("Inner", persons1);
            result.put("Outer", new ArrayList<Person>());
            return result;
        }

        List<Person> inner = getInnerPerson(persons1, persons2);
        List<Person> outer = getOuterPerson(persons1, persons2);

        Set<Person> outerSet = new HashSet<Person>(outer);
        outer = new ArrayList<>(outerSet);
        Set<Person> innerSet = new HashSet<Person>(inner);
        inner = new ArrayList<>(innerSet);

        result.put("Inner", inner);
        result.put("Outer", outer);
        return result;
    }

    @Override
    public List<Person> getUniquePersonsOfSameAge(int age, List<Person> persons1, List<Person> persons2) {

        List<Person> outer = getOuterPerson(persons1, persons2);

        List<Person> result = new ArrayList<Person>(outer);
        for (Person person: outer) {
            if (person.getAge()!=age)
                result.remove(person);
        }
        return result;
    }

    @Override
    public Map<String, List<Person>> getInnerAndOuterPersons(List<Person>... personsArray) {

        if (personsArray.length<2) throw new IllegalArgumentException();

        Map<String, List<Person>> result = new HashMap<String, List<Person>>();

        List<Person> inner = getInnerPerson(personsArray);
        List<Person> outer = getOuterPerson(personsArray);

        Set<Person> outerSet = new HashSet<Person>(outer);
        outer = new ArrayList<>(outerSet);
        Set<Person> innerSet = new HashSet<Person>(inner);
        inner = new ArrayList<>(innerSet);

        result.put("Inner", inner);
        result.put("Outer", outer);
        return result;
    }

    @Override
    public List<Person> getUniquePersonsOfSameAge(int age, List<Person>... personsArray) {
        if (personsArray.length<2) throw new IllegalArgumentException();

        List<Person> outer = getOuterPerson(personsArray);

        List<Person> result = new ArrayList<>(outer);
        for (Person person: outer) {
            if (person.getAge()!=age)
                result.remove(person);
        }

        return result;
    }

    private int getLength(Collection<Person> coll) {
        return coll != null ? coll.size() : 0;
    }

    private List<Person> getInnerPerson (List<Person> persons1, List<Person> persons2) {

        List<Person> result = new ArrayList<Person>();
        for(Person person1 : persons1) {
            for (Person person2 : persons2) {
                if (person1.getLastName().equals(person2.getLastName())&&!person1.equals(person2)) {
                    if(!result.contains(person1)) result.add(person1);
                    if(!result.contains(person2)) result.add(person2);
                    break;
                }
            }
        }
        return result;
    }

    private List<Person> getInnerPerson (List<Person>... personsArray) {

        List<Person> inner = new ArrayList<Person>();
        for(int i=0; i<personsArray.length; i++) {
            for(int j=i+1; j<personsArray.length; j++) {
                List<Person> tempInner = getInnerPerson(personsArray[i], personsArray[j]);
                inner.addAll(tempInner);
            }
        }
        return inner;
    }

    private List<Person> getOuterPerson(List<Person> persons1, List<Person> persons2) {

        List<Person> inner =  getInnerPerson(persons1,persons2);

        List<Person> outer = new ArrayList<Person>();
        outer.addAll(persons1);
        outer.addAll(persons2);
        outer.removeAll(inner);

        return outer;
    }

    private List<Person> getOuterPerson(List<Person>... personsArray) {

        List<Person> inner =  getInnerPerson(personsArray);

        List<Person> outer = new ArrayList<Person>();
        for (int i=0; i<personsArray.length; i++) {
            outer.addAll(personsArray[i]);
        }
        outer.removeAll(inner);

        return outer;
    }
}
