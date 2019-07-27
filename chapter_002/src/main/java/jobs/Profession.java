package ru.job4j.jobs;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private long birthday;

    public Profession(String name, String surname, String education, long birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public Profession() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }
}