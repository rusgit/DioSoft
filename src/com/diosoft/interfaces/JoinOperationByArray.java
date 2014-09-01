package com.diosoft.interfaces;

import com.diosoft.domain.Person;

public interface JoinOperationByArray {

    public Person[] merge(Person[] firstArray, Person[] secondArray);

    public Person[] leftUnion(Person[] firstArray, Person[] secondArray);

    public Person[] innerJoin(Person[] firstArray, Person[] secondArray);

    public Person[] outerJoin(Person[] firstArray, Person[] secondArray);
}
