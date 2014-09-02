package com.diosoft.domain;

public class Person implements Comparable<Person> {

    //local code review (vtegza): if you prefer inner class - put it in the bottom of file/class @ 31.08.14
    // (rusgit): corrected
    private final String name;
    private final String lastName;
    private final int age;
    private final Post post;

    private Person(Builder builder) {
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.post = builder.post;
    }

    public Post getPost() {
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
        sb.append(name).append(", ").append(lastName).append(", ")
                .append(post.toString()).append(", ").append(age).append(" } \n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Person)) return false;
        if (this == obj) return true;

        Person person = (Person) obj;

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

    //local code review (vtegza): try with Comporator @ 31.08.14
    @Override
    public int compareTo(Person obj) {
        if (obj == null) return 1;
        Person person = (Person) obj;
        int result = name.compareTo(person.name);
        if (result != 0) return (int) (result / Math.abs(result));
        result = lastName.compareTo(person.lastName);
        if (result != 0) return (int) (result / Math.abs(result));
        result = post.compareTo(person.post);
        if (result != 0) return (int) (result / Math.abs(result));
        result = age - person.age;

        return (result != 0) ? (int) (result / Math.abs(result)) : 0;
    }


    public static class Builder {
        private String name;
        private String lastName;
        private int age;
        private Post post;

        public Builder() {}

        public Builder(Person original) {
            this.name = original.name;
            this.lastName = original.lastName;
            this.age = original.age;
            this.post = original.post;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String secondName) {
            this.lastName = secondName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder post(Post post) {
            this.post = post;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public enum Post {
        DEVELOPER,
        QA,
        DIRECTOR
    }
}
