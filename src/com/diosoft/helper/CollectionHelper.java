package com.diosoft.helper;

import com.diosoft.common.Person;
import java.util.List;
import java.util.Set;

public interface CollectionHelper {

    Set<Person> merge(List<Person> firstArray, List<Person> secondArray);

    List<Person> leftUnion(List<Person> firstArray, List<Person> secondArray);

    Set<Person> innerJoin(List<Person> firstArray, List<Person> secondArray);

    List<Person> outerJoin(List<Person> firstArray, List<Person> secondArray);
}
