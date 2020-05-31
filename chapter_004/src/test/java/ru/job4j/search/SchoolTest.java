package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SchoolTest {
    @Test
    public void listToMap() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(100, "Иванов"));
        students.add(new Student(60, "Петров"));
        students.add(new Student(30, "Сидоров"));
        Map<String, Student> result = School.collect(students);
        assertThat(result.get("Иванов").getScore(), is(100));
        assertThat(result.get("Петров").getSurname(), is("Петров"));
    }
}
