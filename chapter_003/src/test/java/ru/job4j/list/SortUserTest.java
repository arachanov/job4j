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
        list.add(new User("Pier", 28));
        list.add(new User("Egor", 19));
        list.add(new User("Raul", 37));
        SortUser sortUser = new SortUser();
        assertThat(sortUser.sort(list), is(list.get(2)));
    }
}
