package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {


    public static Map<String, Student> collect(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getSurname, student -> student, (firstStudent, secondStudent) -> firstStudent));
    }
}
