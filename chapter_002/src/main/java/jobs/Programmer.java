package ru.job4j.jobs;

public class Programmer extends Engineer {
    public Programmer(String name, String surname, String edu, long date) {

        this.setName(name);
        this.setSurname(surname);
        this.setEducation(edu);
        this.setBirthday(date);
    }
}