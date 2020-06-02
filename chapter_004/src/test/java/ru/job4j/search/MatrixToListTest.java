package ru.job4j.search;

import org.junit.Test;
import java.util.List;

import static java.util.List.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class MatrixToListTest {
    @Test
    public void whenConvertMatrixToList() {
        Integer[][] num = {
                {1, 2},
                {3, 4}
        };
        List<Integer> result = MatrixToList.convertMatrixToList(num);
        List<Integer> expected = of(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}