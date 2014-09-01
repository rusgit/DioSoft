package com.diosoft.util;

import com.diosoft.domain.Person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person obj1, Person obj2) {

        if (obj1==null&&obj2==null) return 0;
        if (obj1==null) return 1;
        if (obj2==null) return -1;

        int result = obj1.getName().compareTo(obj2.getName());
        if (result != 0) return (result/Math.abs(result));

        result = obj1.getLastName().compareTo(obj2.getLastName());
        if (result != 0) return (result/Math.abs(result));

        result = obj1.getPost().compareTo(obj2.getPost());
        if (result != 0) return (result/Math.abs(result));

        result = obj1.getAge() - obj2.getAge();
        return (result != 0) ? (result/Math.abs(result)) : 0;

    }
}
