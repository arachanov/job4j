package ru.job4j.list;

import java.util.Arrays;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (int step : list) {
          if (j != cells) {
              array[i][j] = step;
              j++;
          } else {
              j = 0;
              i++;
              array[i][j] = step;
              j++;
          }
        }
        while (j != cells) {
            array[i][j] = 0;
            j++;
        }

        return array;
    }

}
