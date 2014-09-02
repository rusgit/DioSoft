package com.diosoft.impl;

import com.diosoft.domain.Person;
import com.diosoft.interfaces.JoinOperationByCollection;
import com.diosoft.util.PersonComparator;
import org.springframework.beans.support.PropertyComparator;

import javax.inject.Named;
import java.util.*;

@Named("collectionHelper")
public class CollectionHelper implements JoinOperationByCollection {

    public CollectionHelper(){
    }

    @Override
    public Set<Person> merge(List<Person> firstColl, List<Person> secondColl) {

       if (getLength(firstColl) == 0)
            return new HashSet<Person>(secondColl);

       if (getLength(secondColl) == 0)
            return new HashSet<Person>(firstColl);

       Set<Person> result = new HashSet<Person>(firstColl);
       result.addAll(secondColl);
       return result;
    }

    @Override
    public List<Person> leftUnion(List<Person> firstColl, List<Person> secondColl) {

        if (getLength(firstColl) == 0)
            return new ArrayList<Person>();

        if (getLength(secondColl) == 0)
            return new ArrayList<Person>(firstColl);

        List<Person> result = new ArrayList<Person>(firstColl);
        Collections.sort(result,new PersonComparator());
        for (Person person : secondColl) {
            int p = Collections.binarySearch(result,person);
            if (p>=0) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public Set<Person> innerJoin(List<Person> firstColl, List<Person> secondColl) {

        if (getLength(firstColl) == 0)
            return new HashSet<Person>();

        if (getLength(secondColl) == 0)
            return new HashSet<Person>();

        Set<Person> result = new HashSet<Person>(firstColl);
        result.retainAll(secondColl);
        return result;
    }

    @Override
    public List<Person> outerJoin(List<Person> firstColl, List<Person> secondColl) {

        if (getLength(firstColl) == 0)
            return new ArrayList<Person>(secondColl);

        if (getLength(secondColl) == 0)
            return new ArrayList<Person>(firstColl);

        List<Person> result1 = new ArrayList<Person>(firstColl);
        result1.removeAll(secondColl);
        List<Person> result2 = new ArrayList<Person>(secondColl);
        result2.removeAll(firstColl);

        List<Person> result = new ArrayList<Person>();
        result.addAll(result1);
        result.addAll(result2);

        return result;
    }

    private int getLength(Collection<Person> coll) {
        return coll != null ? coll.size() : 0;
    }
}

