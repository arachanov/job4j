package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public List<Integer> convert(List<int[]> list) {
        List<Integer> res = new ArrayList<Integer>();
        for (int[] i : list) {
            for (int j : i) {
                res.add(j);
            }
        }
        return res;
    }
}
