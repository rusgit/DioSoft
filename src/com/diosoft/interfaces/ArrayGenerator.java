package com.diosoft.interfaces;

import com.diosoft.domain.Person;
import java.util.Map;

public interface ArrayGenerator {

    Map<String,Person[]> createArrays(int sizeFirstArray, int sizeSecondArray);

    public Map<String,Person[]> createArraysWithDupl(int sizeFirstArray, int sizeSecondArray, int countDuplInFirstArr, int countDuplInSecondArr);

}
