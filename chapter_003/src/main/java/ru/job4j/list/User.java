package ru.job4j.list;

public class User implements Comparable<User> {
    //private int id;
    private String name;
   // private String city;
    private int age;

    public User(String name, int age) {
        //this.id = id;
        this.name = name;
        //this.city = city;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }

}
