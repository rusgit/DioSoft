package com.diosoft.util;

import com.diosoft.common.Person;
import java.util.List;
import java.util.Map;

public interface PersonGenerator {

    Map<String,Person[]> createArrays(int sizeFirstArray, int sizeSecondArray);

    List<Person>[] createSameSurnameMore2array(int numberArrays);

    Map<String,Person[]> createArraysWithDupl(int sizeFirstArray, int sizeSecondArray, int countDuplInFirstArr, int countDuplInSecondArr);

}
