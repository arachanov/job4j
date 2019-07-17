package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortArrayTest {
    @Test
    public void testMergeArrays() {
        SortArray array = new SortArray();
        int[] array1 = new int[]{1, 3};
        int[] array2 = new int[]{2, 4};
        int[] result = array.sort(array1, array2);
        int[] expect = new int[]{1, 2, 3, 4};
        assertThat(result, is(expect));

    }
}