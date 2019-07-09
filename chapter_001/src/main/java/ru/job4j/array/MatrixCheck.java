package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int dlina = data.length - 1;
        int dlina2 = data.length - 2;
           for (int i = 0; i < dlina; i++) {
               if ((data[i][i] == data[i + 1][i + 1]) || (data[i][dlina - i] == data[i + 1][dlina2 - i])) {
                   continue;
               } else {
                   result = false;
                   break;
               }
        }
        return result;
    }
}