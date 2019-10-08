package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] array1 : array) {
            for (int value : array1) {
                list.add(value);
            }
        }
        return list;
    }
}