package com.diosoft.helper;

import com.diosoft.common.Person;
import com.diosoft.util.PersonComparator;
import javax.inject.Named;
import java.util.*;

@Named("collectionHelperImpl")
public class CollectionHelperImpl implements CollectionHelper {

    public CollectionHelperImpl(){
    }

    @Override
    public Set<Person> merge(List<Person> firstColl, List<Person> secondColl) {

       if (getLength(firstColl) == 0)
            return new HashSet<Person>(secondColl);

       if (getLength(secondColl) == 0)
            return new HashSet<Person>(firstColl);

       Set<Person> result = new TreeSet<>(firstColl);
       result.addAll(secondColl);
       return result;
    }

    @Override
    public List<Person> leftUnion(List<Person> firstColl, List<Person> secondColl) {

        if (getLength(firstColl) == 0)
            return new ArrayList<Person>();

        if (getLength(secondColl) == 0)
            return new ArrayList<Person>(firstColl);

        List<Person> result = new ArrayList<>(firstColl);
        Collections.sort(result, new PersonComparator());
        for (Person obj : secondColl) {
            int p = Collections.binarySearch(result,obj,new PersonComparator());
            if (p>=0) {
                result.add(obj);
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

        Set<Person> result = new TreeSet<>(firstColl);
        result.retainAll(secondColl);
        return result;
    }

    @Override
    public List<Person> outerJoin(List<Person> firstColl, List<Person> secondColl) {

        if (getLength(firstColl) == 0)
            return new ArrayList<Person>(secondColl);

        if (getLength(secondColl) == 0)
            return new ArrayList<Person>(firstColl);

        List<Person> result1 = new ArrayList<>(firstColl);
        result1.removeAll(secondColl);
        List<Person> result2 = new ArrayList<>(secondColl);
        result2.removeAll(firstColl);

        List<Person> result = new ArrayList<>();
        result.addAll(result1);
        result.addAll(result2);

        return result;
    }

    private int getLength(Collection<Person> coll) {
        return coll != null ? coll.size() : 0;
    }
}

