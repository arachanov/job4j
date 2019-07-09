package ru.job4j.array;

/**
 * @author Salim
 * @since 05072019
 * @version 001
 */
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}