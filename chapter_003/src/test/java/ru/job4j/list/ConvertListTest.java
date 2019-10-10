package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertListTest {
    @Test
    public void convertListTestMethod() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(list);
        List<Integer> expect = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result, is(expect));
    }
}
