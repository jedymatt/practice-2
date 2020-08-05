package testlearning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListAndMap {

    public static void main(String[] args) {
        Person person;
        List<Person> friends = new ArrayList<>();

        person = new Person("Jane", 10, 'F');
        friends.add(person);
        person = new Person("Jack", 16, 'M');
        friends.add(person);
        person = new Person("Jill", 8, 'F');
        friends.add(person);
        person = new Person("John", 12, 'M');
        friends.add(person);

        Person p;
        Iterator<Person> itr = friends.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            System.out.println(p.getName());
        }
        for (Person pp : friends) {
            System.out.println(pp.getName());
        }
        friends.forEach((ppp) -> {
            System.out.println(ppp.getName());
        });
    }

}

class Person {

    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

}
