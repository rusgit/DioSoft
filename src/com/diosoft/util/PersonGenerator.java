package com.diosoft.util;

import com.diosoft.domain.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PersonGenerator {

    private Person person1 = new Person.Builder().name("Ruslan").lastName("Borisov").age(25).post(Person.Post.DEVELOPER).build();
    private Person person2 = new Person.Builder().name("Anton").lastName("Zemlyankin").age(22).post(Person.Post.DEVELOPER).build();
    private Person person3 = new Person.Builder().name("Ekaterina").lastName("Volkova").age(28).post(Person.Post.DEVELOPER).build();
    private Person person4 = new Person.Builder().name("Illya").lastName("Pinchuk").age(20).post(Person.Post.QA).build();
    private Person person5 = new Person.Builder().name("Elena").lastName("Kirichenko").age(30).post(Person.Post.QA).build();
    private Person person6 = new Person.Builder().name("Vladimir").lastName("Kudyna").age(35).post(Person.Post.QA).build();
    private Person person7 = new Person.Builder().name("Vitaliy").lastName("Bondar").age(31).post(Person.Post.QA).build();
    private Person person8 = new Person.Builder().name("Violete").lastName("Egorova").age(40).post(Person.Post.DIRECTOR).build();
    private Person person9 = new Person.Builder().name("Svyatoslav").lastName("Drobich").age(45).post(Person.Post.DIRECTOR).build();
    private Person person10 = new Person.Builder().name("Svetlana").lastName("Mirnaya").age(50).post(Person.Post.DIRECTOR).build();

    public Map<String,Person[]> createArraysWithOutDupl(int sizeFirstArray, int sizeSecondArray){

        Person[] standartArray = {person1,person2,person3,person4,person5,person6,person7,person8,person9,person10};
        Person[] firstArray = new Person[sizeFirstArray];
        Person[] secondArray = new Person[sizeSecondArray];

        Random rnd = new Random();
        for (int i=0; i < sizeFirstArray; ) {
            int j = rnd.nextInt(10);
            if (!includes(firstArray,standartArray[j])) {
                firstArray[i] = standartArray[j];
                i++;
            }
        }

        for (int i=0; i < sizeSecondArray; ) {
            int j = rnd.nextInt(10);
            if (!includes(secondArray,standartArray[j])) {
                secondArray[i] = standartArray[j];
                i++;
            }
        }

        Map<String,Person[]> arrays = new HashMap<>();
        arrays.put("firstArray", firstArray);
        arrays.put("secondArray", secondArray);

        return arrays;
    }

    public Map<String,Person[]> createArraysWithDupl(int sizeFirstArray, int sizeSecondArray, int countDuplInFirstArr, int countDuplInSecondArr){

        Person[] standartArray = {person1,person2,person3,person4,person5,person6,person7,person8,person9,person10};
        Person[] firstArray = new Person[sizeFirstArray];
        Person[] secondArray = new Person[sizeSecondArray];
        Random rnd = new Random();

        int indexFirst = sizeFirstArray-countDuplInFirstArr;
        for (int i=0; i < indexFirst; ) {
            int j = rnd.nextInt(10);
            if (!includes(firstArray,standartArray[j])) {
                firstArray[i] = standartArray[j];
                i++;
            }
        }
        for (int i=indexFirst; i<sizeFirstArray; i++){
            firstArray[i] = firstArray[rnd.nextInt(indexFirst)];
        }

        int indexSecond = sizeSecondArray-countDuplInSecondArr;
        for (int i=0; i < indexSecond; ) {
            int j = rnd.nextInt(10);
            if (!includes(secondArray,standartArray[j])) {
                secondArray[i] = standartArray[j];
                i++;
            }
        }
        for (int i=indexSecond; i<sizeSecondArray; i++){
            secondArray[i] = secondArray[rnd.nextInt(indexSecond)];
        }

        Map<String,Person[]> arrays = new HashMap<>();
        arrays.put("firstArray", firstArray);
        arrays.put("secondArray", secondArray);

        return arrays;
    }

    private boolean includes(Person[] array, Person person) {
        for (Person arrPerson : array) {
            if (person.equals(arrPerson)) return true;
        }
        return false;
    }


}
