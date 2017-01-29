package com.michaelgokeefe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 1/27/17.
 */
public class LinkedListCh2Test {
    @Test
    public void removeDups() throws Exception {
        int[] withDups = new int[] { 1, 5, 5, 8, 4, 2, 4, 8, 9, 66, 1, 1 };
        int[] withoutDups = new int[] {1, 5, 8, 4, 2, 9, 66 };

        LinkedListCh2 list = new LinkedListCh2(withDups);

        assertArrayEquals(withDups, list.toIntArray());

        list.removeDups();

        assertArrayEquals(withoutDups, list.toIntArray());
    }

    @Test
    public void testIndexFromBack() throws Exception {
        int[] array = new int[] { 1, 6, 9, 5, 3, 7, 2 };

        LinkedListCh2 list = new LinkedListCh2(array);

        assertEquals(2, list.indexFromTheBack(0));
        assertEquals(3, list.indexFromTheBack(2));
        assertEquals(-1, list.indexFromTheBack(100));
        assertEquals(6, list.indexFromTheBack(5));
    }

}