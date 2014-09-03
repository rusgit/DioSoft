package com.diosoft.interfaces;

import com.diosoft.domain.Person;

import java.util.List;
import java.util.Set;

public interface JoinOperationByCollection {

    public Set<Person> merge(List<Person> firstArray, List<Person> secondArray);

    public List<Person> leftUnion(List<Person> firstArray, List<Person> secondArray);

    public Set<Person> innerJoin(List<Person> firstArray, List<Person> secondArray);

    public List<Person> outerJoin(List<Person> firstArray, List<Person> secondArray);
}
