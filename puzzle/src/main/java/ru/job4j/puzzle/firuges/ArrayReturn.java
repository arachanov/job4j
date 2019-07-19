package ru.job4j.puzzle.firuges;
public class ArrayReturn {
    public static void main(String[] args) {
        calc(0);
    }
    public static void calc(int value) {
        if (value != 0 && value / 0 >= 0) {
            System.out.println("div by zero");
        } else {
            System.out.println("zero by zero");
        }
    }

}

