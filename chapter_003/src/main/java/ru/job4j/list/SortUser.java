package ru.job4j.list;

import java.util.*;

public class SortUser {
    Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }
}
