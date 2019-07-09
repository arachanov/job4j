package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
    int kol = array.length;
    for (int i = 0; i < kol; i++) {
        for (int j = i + 1; j < kol; j++) {
            if (array[i].equals(array[j])) {
                array[j] = array[kol - 1];
                kol--;
                j--;
            }
        }
    }
    return Arrays.copyOf(array, kol);
    }
}
