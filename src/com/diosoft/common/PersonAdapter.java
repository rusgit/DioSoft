package com.diosoft.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonAdapter implements Comparable<PersonAdapter> {

    @XmlAttribute
    private long id;
    private String name;
    private String lastName;
    private int age;
    private Person.Post post;

    public PersonAdapter() {
    }

    public PersonAdapter(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.lastName = person.getLastName();
        this.age = person.getAge();
        this.post = person.getPost();
    }

    public Person.Post getPost() {
        return post;
    }
    public int getAge() {
        return age;
    }
    public String getLastName() {
        return lastName;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person { ");
        sb.append(id).append(", ").append(name).append(", ").append(lastName).append(", ")
                .append(post.toString()).append(", ").append(age).append(" } \n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof PersonAdapter)) return false;
        if (this == obj) return true;

        PersonAdapter person = (PersonAdapter) obj;

        if (age != person.age) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!name.equals(person.name)) return false;
        if (post != person.post) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        result = 31 * result + post.hashCode();
        return result;
    }

    @Override
    public int compareTo(PersonAdapter obj) {
        if (obj == null) return 1;
        PersonAdapter person = (PersonAdapter) obj;
        int result = name.compareTo(person.name);
        if (result != 0) return (int) (result / Math.abs(result));
        result = lastName.compareTo(person.lastName);
        if (result != 0) return (int) (result / Math.abs(result));
        result = post.compareTo(person.post);
        if (result != 0) return (int) (result / Math.abs(result));
        result = age - person.age;

        return (result != 0) ? (int) (result / Math.abs(result)) : 0;
    }
}
