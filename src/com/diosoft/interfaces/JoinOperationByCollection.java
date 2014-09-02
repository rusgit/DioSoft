package com.diosoft.interfaces;

import java.util.List;
import java.util.Set;

public interface JoinOperationByCollection {

    public <T> Set<T> merge(List<T> firstArray, List<T> secondArray);

    public <T> List<T> leftUnion(List<T> firstArray, List<T> secondArray);

    public <T> Set<T> innerJoin(List<T> firstArray, List<T> secondArray);

    public <T> List<T> outerJoin(List<T> firstArray, List<T> secondArray);
}
