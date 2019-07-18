package ru.job4j.array;

public class SortArray {
    public int[] merge(int[] left, int[] right) {
        int dlina = left.length + right.length;
        int[] array3 = new int[dlina];
        array3[0] = left[0];
        for (int i = 1; i < dlina; i++) {
            if (i < left.length) {
                if (array3[i - 1] > left[i]) {
                array3[i] = array3[i - 1];
                array3[i - 1] = left[i];
                } else {
                    array3[i] = left[i];
                }

            } else {
                if (array3[i - 1] > right[i - right.length]) {
                    array3[i] = array3[i - 1];
                    array3[i - 1] = right[i - right.length];
                } else {
                    array3[i] = right[i - right.length];
                }
            }
        }
        return array3;
    }
}