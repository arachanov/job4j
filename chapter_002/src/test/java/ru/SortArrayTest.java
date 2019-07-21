package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortArrayTest {
    @Test
    public void testArrays() {
        SortArray array = new SortArray();
        int[] array1 = new int[]{1, 3};
        int[] array2 = new int[]{2, 4};
        int[] result = array.merge(array1, array2);
        int[] expect = new int[]{1, 2, 3, 4};
        assertThat(result, is(expect));
    }
    @Test
    public void testeArrays() {
        SortArray array = new SortArray();
        int[] array1 = new int[]{0, 2, 1};
        int[] array2 = new int[]{3, 5, 4};
        int[] result = array.merge(array1, array2);
        int[] expect = new int[]{0, 1, 2, 3, 4, 5};
        assertThat(result, is(expect));

    }
    /*
    @Test
    public void testeArrays2() {
        SortArray array = new SortArray();
        int[] array1 = new int[]{5, 3, 4};
        int[] array2 = new int[]{0, 2, 1};
        int[] result = array.merge(array1, array2);
        int[] expect = new int[]{0, 1, 2, 3, 4, 5};
        assertThat(result, is(expect));

    }*/
}