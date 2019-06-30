package ru.job4j.condition;

/**
 * Класс вычисления сторон прямоугольника
 * @author Salim
 * @since 30.06.2019
 * @version 1.0
 */
public class SqArea {
    /**
     * метод вычиляет площадь
     * @param p периметр
     * @param k коэфицент ширина больше высоты в 2 раза
     * @return площадь
     */
    public int square(int p, int k) {
        int h = (int) Math.sqrt(p / (2 * k));
        int w = h * k;
        return h * w;
    }
}
