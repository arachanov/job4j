package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
}
