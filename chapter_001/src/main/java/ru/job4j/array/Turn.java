package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int pos = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[pos - i];
            array[pos - i] = tmp;
        }
        return array;
    }
}