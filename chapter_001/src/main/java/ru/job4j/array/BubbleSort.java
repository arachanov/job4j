package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length - i; j++) {
                if (j + 1 != mass.length) {
                if (mass[j] > mass[j + 1]) {
                    int tmp = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = tmp;
                }
                }
            }
        }
        return mass;
    }
}
