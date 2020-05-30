package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SchoolTest {
    @Test
    public void whenDiaposonA() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(100, "Иванов"));
        students.add(new Student(60, "Петров"));
        students.add(new Student(30, "Сидоров"));
        List<Student> result = School.collect(students, student -> student.getScore() >= 70);
        assertThat(result.get(0).getSurname(), is("Иванов"));

    }
    @Test
    public void whenDiaposonB() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(100, "Иванов"));
        students.add(new Student(60, "Петров"));
        students.add(new Student(30, "Сидоров"));
        List<Student> result = School.collect(students, student -> student.getScore() < 70 & student.getScore() > 50);
        assertThat(result.get(0).getSurname(), is("Петров"));
    }
    @Test
    public void whenDiaposonC() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(100, "Иванов"));
        students.add(new Student(60, "Петров"));
        students.add(new Student(30, "Сидоров"));
        List<Student> result = School.collect(students, student -> student.getScore() <= 50);
        assertThat(result.get(0).getSurname(), is("Сидоров"));

    }
}
