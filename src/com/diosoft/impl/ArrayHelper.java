package com.diosoft.impl;

import com.diosoft.domain.Person;
import com.diosoft.interfaces.JoinOperationByArray;
import com.diosoft.util.PersonComparator;
import java.util.Arrays;
import javax.inject.Named;

@Named("arrayHelper")
public class ArrayHelper implements JoinOperationByArray {

    public ArrayHelper(){
    }

   public Person[] merge(Person[] firstArray, Person[] secondArray) {

        int firstArrayLength = getLength(firstArray);
        int secondArrayLenght = getLength(secondArray);

        if (firstArrayLength == 0)
            return deleteDuplicate(secondArray);

        if (secondArrayLenght == 0)
            return deleteDuplicate(firstArray);


        Person[] mergeArray = new Person[firstArray.length + secondArray.length];
// Add all elements from First Array and Second Array
        System.arraycopy(firstArray, 0, mergeArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, mergeArray, firstArray.length, secondArray.length);
// Delete duplicate
        return deleteDuplicate(mergeArray);
    }

   public Person[] leftUnion(Person[] firstArray, Person[] secondArray) {
       int firstArrayLength = getLength(firstArray);
       int secondArrayLenght = getLength(secondArray);

       if (firstArrayLength == 0)
           return new Person[]{};

       if (secondArrayLenght == 0)
           return firstArray;

       Person[] leftUnionArray = new Person[firstArray.length + secondArray.length];
// Add all elements from First Array
       System.arraycopy(firstArray, 0, leftUnionArray, 0, firstArray.length);
// Add all elements from Second Array, which are contented in First Array.
       int counter = firstArray.length;
       Arrays.sort(firstArray, new PersonComparator());
       for (Person person : secondArray) {
           int k = Arrays.binarySearch(firstArray, person);
           if (k >= 0) {
               leftUnionArray[counter] = person;
               counter++;
           }
       }
       return trimArray(leftUnionArray,counter);
   }

   public Person[] innerJoin(Person[] firstArray, Person[] secondArray) {

        int firstArrayLength = getLength(firstArray);
        int secondArrayLenght = getLength(secondArray);

        if ((firstArrayLength == 0) || (secondArrayLenght == 0) )
            return new Person[]{};

        int length = (firstArray.length < secondArray.length) ? firstArray.length : secondArray.length;
        Person[] innerJoinArray = new Person[length];

// Add all elements from First Array, which are contented in Second Array.
        int counter = 0;
        Arrays.sort(secondArray, new PersonComparator());
        for (Person person : firstArray) {
            int k = Arrays.binarySearch(secondArray, person);
            if (k >= 0) {
// Adding -> if this element doesn't exist in result array
                if (!includes(innerJoinArray,person)) {
                    innerJoinArray[counter] = secondArray[k];
                    counter++;
                }
            }
        }
        return trimArray(innerJoinArray,counter);
   }

   public Person[] outerJoin(Person[] firstArray, Person[] secondArray) {

        int firstArrayLength = getLength(firstArray);
        int secondArrayLenght = getLength(secondArray);

        if (firstArrayLength == 0)
            return secondArray;
        if (secondArrayLenght == 0)
            return firstArray;

        Person[] outerJoinArray = new Person[firstArray.length + secondArray.length];

// Add all elements from FirstArray, which are not contented in SecondArray.
        int counter = 0;
        Arrays.sort(secondArray, new PersonComparator());
        for (Person person : firstArray) {
            int k = Arrays.binarySearch(secondArray, person);
            if (k < 0) {
                outerJoinArray[counter] = person;
                counter++;
            }
        }
// Add all elements from SecondArray, which are not contented in FirstArray.
        Arrays.sort(firstArray, new PersonComparator());
        for (Person person : secondArray) {
            int k = Arrays.binarySearch(firstArray, person);
            if (k < 0) {
                outerJoinArray[counter] = person;
                counter++;
            }
        }
        return trimArray(outerJoinArray,counter);
   }


   private int getLength(Person[] array) {
        return array != null ? array.length : 0;
   }

   private Person[] trimArray(Person[] array, int length) {
        Person[] result = new Person[length];
        System.arraycopy(array, 0, result, 0, result.length);
        return result;
   }

   private boolean includes(Person[] array, Person person) {
        for (Person arrPerson : array) {
            if (person.equals(arrPerson)) return true;
        }
        return false;
   }

   private Person[] deleteDuplicate(Person[] array) {
        int count = 0;
        Person[] result = new Person[array.length];
        for (Person person : array) {
            if (!includes(result, person)) {
                result[count] = person;
                count++;
            }
        }
        return trimArray(result, count);
   }

}
