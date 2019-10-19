package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = left.length() - right.length();
        int steps = result > 0 ? right.length() : left.length();
        for (int i = 0; i < steps; i++) {
        result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
            if (i == steps - 1) {
                result = left.length() - right.length();
            }
        }
        return result;
    }
}
