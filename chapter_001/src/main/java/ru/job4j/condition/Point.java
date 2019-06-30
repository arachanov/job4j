package ru.job4j.condition;

/**
 * Класс Поинт для вычисления растояния между точками
 * @author Salim
 * @since 30.06.2019
 * @version 1
 */
public class Point {
    public double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow(x2 - x1, 2);
        double second = Math.pow(y2 - y1, 2);
        return Math.sqrt(first + second);
    }
}