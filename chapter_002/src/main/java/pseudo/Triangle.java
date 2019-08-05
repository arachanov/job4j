package ru.job4j.pseudo;

import ru.job4j.pseudo.Shape;

import java.util.StringJoiner;

public class Triangle implements Shape {
    @Override
    public String draw() {
       return new StringJoiner(
                System.lineSeparator(), "",
                System.lineSeparator())
                .add("  ^  ")
                .add(" ^ ^ ")
                .add("^^^^^")
                .toString();
    }
}