package ru.job4j.array;

/**
 * @author Salim
 * @since 05072019
 * @version 001
 */
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        int checktrue = 0;
        int checkfalse = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i]) {
                checktrue++;
            } else {
                checkfalse++;
            }
        }
        if (checktrue == data.length) {
            result = true;
        }
        if (checkfalse == data.length) {
            result = true;
        }
        return result;
    }
}