package com.diosoft.helper;

import com.diosoft.common.Person;
import java.util.List;
import java.util.Map;

public interface PersonOperations {

    //local code review (vtegza): no need in public - it is already public by interface definition @ 9/28/2014
    public Map<String, List<Person>> getInnerAndOuterPersons(List<Person> persons1, List<Person> persons2);

    public List<Person> getUniquePersonsOfSameAge(int age, List<Person> persons1, List<Person> persons2);

    public Map<String, List<Person>> getInnerAndOuterPersons(List<Person>... persons);

    public List<Person> getUniquePersonsOfSameAge(int age, List<Person>... persons);
}
