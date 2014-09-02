package com.diosoft.impl;

import com.diosoft.interfaces.JoinOperationByCollection;
import javax.inject.Named;
import java.util.*;

@Named("collectionHelper")
public class CollectionHelper implements JoinOperationByCollection {

    public CollectionHelper(){
    }

    @Override
    public <T> Set<T> merge(List<T> firstColl, List<T> secondColl) {

       if (getLength(firstColl) == 0)
            return new HashSet<T>(secondColl);

       if (getLength(secondColl) == 0)
            return new HashSet<T>(firstColl);

       Set<T> result = new HashSet<T>(firstColl);
       result.addAll(secondColl);
       return result;
    }

    @Override
    public <T> List<T> leftUnion(List<T> firstColl, List<T> secondColl) {

        if (getLength(firstColl) == 0)
            return new ArrayList<T>();

        if (getLength(secondColl) == 0)
            return new ArrayList<T>(firstColl);

        List<T> result = new ArrayList<T>(firstColl);
        for (T person : secondColl) {
            if (result.contains(person)) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public <T> Set<T> innerJoin(List<T> firstColl, List<T> secondColl) {

        if (getLength(firstColl) == 0)
            return new HashSet<T>();

        if (getLength(secondColl) == 0)
            return new HashSet<T>();

        Set<T> result = new HashSet<T>(firstColl);
        result.retainAll(secondColl);
        return result;
    }

    @Override
    public <T> List<T> outerJoin(List<T> firstColl, List<T> secondColl) {

        if (getLength(firstColl) == 0)
            return new ArrayList<T>(secondColl);

        if (getLength(secondColl) == 0)
            return new ArrayList<T>(firstColl);

        firstColl.removeAll(secondColl);
        secondColl.removeAll(firstColl);

        List<T> result = new ArrayList<T>();
        result.addAll(firstColl);
        result.addAll(secondColl);
        return result;
    }

    private <T> int getLength(Collection<T> coll) {
        return coll != null ? coll.size() : 0;
    }
}

