package com.diosoft.service;

import com.diosoft.common.Person;

public interface ArrayService {

    Person[] merge(Person[] firstArray, Person[] secondArray);

    Person[] leftUnion(Person[] firstArray, Person[] secondArray);

    Person[] innerJoin(Person[] firstArray, Person[] secondArray);

    Person[] outerJoin(Person[] firstArray, Person[] secondArray);


}
