package ru.job4j.loop;

/**
 * @author Salim
 * @since 02072019
 */
public class Factorial {
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
