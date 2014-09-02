package com.diosoft.impl;

import com.diosoft.interfaces.JoinOperationByCollection;
import com.diosoft.util.NaturalComparator;
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

       Set<T> result = new TreeSet<>(firstColl);
       result.addAll(secondColl);
       return result;
    }

    @Override
    public <T> List<T> leftUnion(List<T> firstColl, List<T> secondColl) {

        if (getLength(firstColl) == 0)
            return new ArrayList<T>();

        if (getLength(secondColl) == 0)
            return new ArrayList<T>(firstColl);

        List<T> result = new ArrayList<>(firstColl);
        Collections.sort(result, new NaturalComparator());
        for (T obj : secondColl) {
            int p = Collections.binarySearch(result,obj,new NaturalComparator());
            if (p>=0) {
                result.add(obj);
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

        Set<T> result = new TreeSet<>(firstColl);
        result.retainAll(secondColl);
        return result;
    }

    @Override
    public <T> List<T> outerJoin(List<T> firstColl, List<T> secondColl) {

        if (getLength(firstColl) == 0)
            return new ArrayList<T>(secondColl);

        if (getLength(secondColl) == 0)
            return new ArrayList<T>(firstColl);

        List<T> result1 = new ArrayList<>(firstColl);
        result1.removeAll(secondColl);
        List<T> result2 = new ArrayList<>(secondColl);
        result2.removeAll(firstColl);

        List<T> result = new ArrayList<>();
        result.addAll(result1);
        result.addAll(result2);

        return result;
    }

    private <T> int getLength(Collection<T> coll) {
        return coll != null ? coll.size() : 0;
    }
}

