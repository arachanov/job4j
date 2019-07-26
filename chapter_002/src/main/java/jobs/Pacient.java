package ru.job4j.jobs;

public class Pacient {
    String name;
    int age;

    public Pacient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}