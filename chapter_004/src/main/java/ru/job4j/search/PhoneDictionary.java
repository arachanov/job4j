package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /*public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        ...
        return result;
    }*/
    public ArrayList<Person> find(String key) {
        Predicate<Person> checkAddress = person -> person.getAddress().contains(key);
        Predicate<Person> checkName = person -> person.getName().contains(key);
        Predicate<Person> checkSurname = person -> person.getSurname().contains(key);
        Predicate<Person> checkPhone = person -> person.getPhone().contains(key);
        Predicate<Person> combine = checkAddress.or(checkName).or(checkSurname).or(checkPhone);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}