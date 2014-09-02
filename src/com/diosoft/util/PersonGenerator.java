package com.diosoft.util;


import com.diosoft.domain.Person;

public class PersonGenerator {

    static Person person1 = new Person.Builder().name("Ruslan").lastName("Borisov").age(25).post(Person.Post.DEVELOPER).build();
    static Person person2 = new Person.Builder().name("Anton").lastName("Zemlyankin").age(22).post(Person.Post.DEVELOPER).build();
    static Person person3 = new Person.Builder().name("Ekaterina").lastName("Volkova").age(28).post(Person.Post.DEVELOPER).build();
    static Person person4 = new Person.Builder().name("Illya").lastName("Pinchuk").age(20).post(Person.Post.QA).build();
    static Person person5 = new Person.Builder().name("Elena").lastName("Kirichenko").age(30).post(Person.Post.QA).build();
    static Person person6 = new Person.Builder().name("Vladimir").lastName("Kudyna").age(35).post(Person.Post.QA).build();
    static Person person7 = new Person.Builder().name("Vitaliy").lastName("Bondar").age(31).post(Person.Post.QA).build();
    static Person person8 = new Person.Builder().name("Violete").lastName("Egorova").age(40).post(Person.Post.DIRECTOR).build();
    static Person person9 = new Person.Builder().name("Svyatoslav").lastName("Drobich").age(45).post(Person.Post.DIRECTOR).build();
    static Person person10 = new Person.Builder().name("Svetlana").lastName("Mirnaya").age(50).post(Person.Post.DIRECTOR).build();


    public static Person[] persons() {

        Person[] persons = {person1,person2,person3,person4,person5,person6,person7,person8,person9,person10};
        return persons;
    }


}
