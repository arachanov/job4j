package ru.job4j.list;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void sortUserTestMethod() {
        List<User> list = new ArrayList();
        list.add(new User("Andy", 27));
        list.add(new User("Pierо", 28));
        list.add(new User("Egorka", 19));
        list.add(new User("RaulGonzalez", 37));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(list);
        assertThat(result.get(result.size() - 1).getName().length(), is(list.get(3).getName().length()));
    }
}
