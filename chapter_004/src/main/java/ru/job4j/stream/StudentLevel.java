package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        Comparator<Student> comparator = Comparator.comparing(Student::getScore);
        return students.stream().flatMap(Stream:: ofNullable).sorted(comparator).dropWhile(el -> el.getScore() < bound).collect(Collectors.toList());
    }
}