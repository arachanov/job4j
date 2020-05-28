package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCounter {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new ArrayList<>();
        while (start < end) {
            double funcRes = func.apply((double) start);
            res.add(funcRes);
            start++;
        }
        return res;
    }
}