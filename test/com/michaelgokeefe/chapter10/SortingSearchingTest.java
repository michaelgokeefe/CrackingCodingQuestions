package com.michaelgokeefe.chapter10;

import com.michaelgokeefe.chapter10.SortingSearching;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/27/17.
 */
public class SortingSearchingTest {
    private int[] expected;
    private int[] actual;

    // merge sort practice
    @Test
    public void mergeSort_SortEmptyArray() {
        setUpExpectedAndActual(new int[0]);
        SortingSearching.mergeSort(actual);
        testExpectedAndActual();
    }

    @Test
    public void mergeSort_SortSingleElementArray() {
        int[] array = new int[]{1};
        setUpExpectedAndActual(array);
        SortingSearching.mergeSort(actual);
        testExpectedAndActual();
    }

    @Test
    public void mergeSort_SortTwoElementArray() {
        int[] array = new int[]{2, 1};
        setUpExpectedAndActual(array);
        SortingSearching.mergeSort(actual);
        testExpectedAndActual();
    }

    @Test
    public void mergeSort_SortLargeArrayOddNumElements() {
        int[] array = new int[] { -1, 3, 435, 56, 54, 33, 75, -45, 67, 8665, 33 };
        setUpExpectedAndActual(array);
        SortingSearching.mergeSort(actual);
        testExpectedAndActual();
    }

    // 10.1
    @Test
    public void merge() throws Exception {
        int[] a = new int[]{1, 5, 10, 17, 19, 0, 0, 0};
        int[] b = new int[]{1, 11, 27};
        SortingSearching.merge(a, b, 4);
        assertArrayEquals(new int[]{1, 1, 5, 10, 11, 17, 19, 27}, a);
    }

    private void setUpExpectedAndActual(int[] arrayToSort) {
        expected = arrayToSort;
        actual = Arrays.copyOf(expected, expected.length);
        Arrays.sort(expected);
    }

    private void testExpectedAndActual() {
        assertArrayEquals(expected, actual);
    }

}