package com.diosoft.util;

import com.diosoft.common.Person;
import java.util.*;

public class PersonGeneratorImpl implements PersonGenerator {

// Original surnames
    private Person person1 = new Person.Builder().id(1).name("Ruslan").lastName("Borisov").age(25).post(Person.Post.DEVELOPER).build();
    private Person person2 = new Person.Builder().id(2).name("Anton").lastName("Zemlyankin").age(22).post(Person.Post.DEVELOPER).build();
    private Person person3 = new Person.Builder().id(3).name("Ekaterina").lastName("Volkova").age(28).post(Person.Post.DEVELOPER).build();
    private Person person4 = new Person.Builder().id(4).name("Illya").lastName("Pinchuk").age(20).post(Person.Post.QA).build();
    private Person person5 = new Person.Builder().id(5).name("Elena").lastName("Kirichenko").age(30).post(Person.Post.QA).build();
    private Person person6 = new Person.Builder().id(6).name("Vladimir").lastName("Kudyna").age(35).post(Person.Post.QA).build();
    private Person person7 = new Person.Builder().id(7).name("Vitaliy").lastName("Bondar").age(31).post(Person.Post.QA).build();
    private Person person8 = new Person.Builder().id(8).name("Violete").lastName("Egorova").age(40).post(Person.Post.DIRECTOR).build();
    private Person person9 = new Person.Builder().id(9).name("Svyatoslav").lastName("Drobich").age(45).post(Person.Post.DIRECTOR).build();
    private Person person10 = new Person.Builder().id(10).name("Svetlana").lastName("Mirnaya").age(50).post(Person.Post.DIRECTOR).build();
// Same surnames
    private Person person11 = new Person.Builder().id(11).name("Ekaterina").lastName("Kudyna").age(25).post(Person.Post.DEVELOPER).build();
    private Person person12 = new Person.Builder().id(12).name("Elena").lastName("Kudyna").age(22).post(Person.Post.DEVELOPER).build();
    private Person person13 = new Person.Builder().id(13).name("Svetlana").lastName("Kudyna").age(28).post(Person.Post.DEVELOPER).build();

    private Person person14 = new Person.Builder().id(14).name("Vladimir").lastName("Borisov").age(20).post(Person.Post.QA).build();
    private Person person15 = new Person.Builder().id(15).name("Svyatoslav").lastName("Borisov").age(30).post(Person.Post.QA).build();
    private Person person16 = new Person.Builder().id(16).name("Ruslan").lastName("Borisov").age(35).post(Person.Post.QA).build();

    private Person person17 = new Person.Builder().id(17).name("Vitaliy").lastName("Kirichenko").age(31).post(Person.Post.QA).build();
    private Person person18 = new Person.Builder().id(18).name("Violeta").lastName("Kirichenko").age(40).post(Person.Post.DIRECTOR).build();
    private Person person19 = new Person.Builder().id(19).name("Svyatoslav").lastName("Kirichenko").age(45).post(Person.Post.DIRECTOR).build();

    private Person person20 = new Person.Builder().id(20).name("Svetlana").lastName("Drobich").age(50).post(Person.Post.DIRECTOR).build();
    private Person person21 = new Person.Builder().id(21).name("Anton").lastName("Drobich").age(35).post(Person.Post.QA).build();
    private Person person22 = new Person.Builder().id(22).name("Vitaliy").lastName("Drobich").age(31).post(Person.Post.QA).build();

    private Person person23 = new Person.Builder().id(23).name("Ruslan").lastName("Zemlyankin").age(40).post(Person.Post.DIRECTOR).build();
    private Person person24 = new Person.Builder().id(24).name("Svyatoslav").lastName("Zemlyankin").age(45).post(Person.Post.DIRECTOR).build();
    private Person person25 = new Person.Builder().id(25).name("Vitaliy").lastName("Zemlyankin").age(50).post(Person.Post.DIRECTOR).build();

    private Person person26 = new Person.Builder().id(26).name("Ruslan").lastName("Kuch").age(40).post(Person.Post.DIRECTOR).build();
    private Person person27 = new Person.Builder().id(27).name("Svyatoslav").lastName("Kuch").age(45).post(Person.Post.DIRECTOR).build();
    private Person person28 = new Person.Builder().id(28).name("Vitaliy").lastName("Kuch").age(50).post(Person.Post.DIRECTOR).build();

    private Person person29 = new Person.Builder().id(29).name("Ruslan").lastName("Milevsky").age(40).post(Person.Post.DIRECTOR).build();
    private Person person30 = new Person.Builder().id(30).name("Svyatoslav").lastName("Milevsky").age(45).post(Person.Post.DIRECTOR).build();
    private Person person31 = new Person.Builder().id(31).name("Vitaliy").lastName("Milevsky").age(50).post(Person.Post.DIRECTOR).build();

    private Person person32 = new Person.Builder().id(32).name("Ruslan").lastName("Horoshiy").age(40).post(Person.Post.DIRECTOR).build();
    private Person person33 = new Person.Builder().id(33).name("Svyatoslav").lastName("Horoshiy").age(45).post(Person.Post.DIRECTOR).build();
    private Person person34 = new Person.Builder().id(34).name("Vitaliy").lastName("Horoshiy").age(50).post(Person.Post.DIRECTOR).build();

    private Person person35 = new Person.Builder().id(35).name("Ruslan").lastName("Volkov").age(40).post(Person.Post.DIRECTOR).build();
    private Person person36 = new Person.Builder().id(36).name("Svyatoslav").lastName("Volkov").age(45).post(Person.Post.DIRECTOR).build();
    private Person person37 = new Person.Builder().id(37).name("Vitaliy").lastName("Volkov").age(50).post(Person.Post.DIRECTOR).build();

    private Person person38 = new Person.Builder().id(38).name("Ruslan").lastName("Landushev").age(40).post(Person.Post.DIRECTOR).build();
    private Person person39 = new Person.Builder().id(39).name("Svyatoslav").lastName("Landushev").age(45).post(Person.Post.DIRECTOR).build();
    private Person person40 = new Person.Builder().id(40).name("Vitaliy").lastName("Landushev").age(50).post(Person.Post.DIRECTOR).build();

    @Override
    public Map<String,Person[]> createArrays(int sizeFirstArray, int sizeSecondArray){

        if(sizeFirstArray<1 || sizeSecondArray<1) throw new IllegalArgumentException();
        if(sizeFirstArray>10) sizeFirstArray=10;
        if(sizeSecondArray>10) sizeSecondArray=10;

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

    @Override
    public List<Person>[] createSameSurnameMore2array(int numberArrays) {

        if (numberArrays < 2) throw new IllegalArgumentException();
//local code review (vtegza): use Arrays.asList @ 9/28/2014
        Person[] standartArray = {
                person11, person12, person13, person14, person15,
                person16, person17, person18, person19, person20,
                person21, person22, person23, person24, person25,
                person26, person27, person28, person29, person30,
                person31, person32, person33, person34, person35,
                person36, person37, person38, person39, person40,
        };

        List<Person>[] arrays = new ArrayList[numberArrays];

        for (int i = 0; i < numberArrays; i++) {
            List<Person> persons = new ArrayList<Person>();
            Random rnd = new Random();
            int randomLength = rnd.nextInt(7);
            if (randomLength < 3) randomLength = 3;

            for (int j = 0; j < randomLength; ) {
                int k = rnd.nextInt(29);
                if (!persons.contains(standartArray[k])) {
                    boolean uniqSurname=true;
                    for(Person person : persons){
                        if(person.getLastName().equals(standartArray[k].getLastName())){
                            uniqSurname=false;
                        }
                    }
                    if(uniqSurname) {
                        persons.add(standartArray[k]);
                        j++;
                    }
                }
            }
            arrays[i] = persons;
        }
        return arrays;
    }

    @Override
    public Map<String,Person[]> createArraysWithDupl(int sizeFirstArray, int sizeSecondArray, int countDuplInFirstArr, int countDuplInSecondArr){

        if(countDuplInFirstArr<1 || countDuplInSecondArr<1 || sizeFirstArray<1 || sizeSecondArray<1) throw new IllegalArgumentException();
        if(sizeFirstArray>10) sizeFirstArray=10;
        if(sizeSecondArray>10) sizeSecondArray=10;
        if(countDuplInFirstArr>10) countDuplInFirstArr=9;
        if(countDuplInSecondArr>10) countDuplInSecondArr=9;
        if(sizeFirstArray==countDuplInFirstArr) countDuplInFirstArr--;
        if(sizeSecondArray==countDuplInSecondArr) countDuplInSecondArr--;

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
