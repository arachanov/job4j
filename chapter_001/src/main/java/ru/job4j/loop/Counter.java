package ru.job4j.loop;

/**
 * @author Salim
 * @since 01.07.2019
 * @version 1
 */
public class Counter {
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
