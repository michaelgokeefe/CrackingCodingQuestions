package com.michaelgokeefe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/27/17.
 */
public class SortingSearchingCh10Test {
    @Test
    public void merge() throws Exception {
        int[] a = new int[] { 1, 5, 10, 17, 19, 0, 0, 0 };
        int[] b = new int[] { 1, 11, 27 };
        SortingSearchingCh10.merge(a, b, 4);
        assertArrayEquals(new int[] { 1, 1, 5, 10, 11, 17, 19, 27 }, a);
    }

}