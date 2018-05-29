package com.michaelgokeefe.chapter10;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/27/17.
 */
public class SortingSearchingTest {
    @Test
    public void merge() throws Exception {
        int[] a = new int[] { 1, 5, 10, 17, 19, 0, 0, 0 };
        int[] b = new int[] { 1, 11, 27 };
        SortingSearching.mergeArrays(a, b, 4);
        assertArrayEquals(new int[] { 1, 1, 5, 10, 11, 17, 19, 27 }, a);
    }

    // merge sort
    @Test
    public void testEmpty() {
        int[] a = new int[] {};
        SortingSearching.mergesort(a);
        assertArrayEquals(new int[] {}, a);
    }

    @Test
    public void testSingleElement() {
        int[] a = new int[] {1};
        SortingSearching.mergesort(a);
        assertArrayEquals(new int[] {1}, a);
    }

    @Test
    public void testEvenElements() {
        int[] a = new int[] {10, 9, 15, 18, -1, 11, 11, 7};
        int[] answer = Arrays.copyOf(a, a.length);
        Arrays.sort(answer);
        SortingSearching.mergesort(a);
        assertArrayEquals(answer, a);
    }

    @Test
    public void testOddElements() {
        int[] a = new int[] {27, 8, -2, -5, -1};
        int[] answer = Arrays.copyOf(a, a.length);
        Arrays.sort(answer);
        SortingSearching.mergesort(a);
        assertArrayEquals(answer, a);
    }



}