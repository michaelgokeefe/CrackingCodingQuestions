package com.michaelgokeefe.chapter2;

import com.michaelgokeefe.chapter2.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 1/27/17.
 */
public class LinkedListTest {
    private int[] listVals = new int[] { 1, 2, 3, 4, 5 };
    private LinkedList list = new LinkedList(listVals);

    @Test
    public void removeDups() throws Exception {
        int[] withDups = new int[] { 1, 5, 5, 8, 4, 2, 4, 8, 9, 66, 1, 1 };
        int[] withoutDups = new int[] {1, 5, 8, 4, 2, 9, 66 };

        LinkedList list = new LinkedList(withDups);

        assertArrayEquals(withDups, list.toIntArray());

        list.removeDups();

        assertArrayEquals(withoutDups, list.toIntArray());
    }

    @Test
    public void testIndexFromBack() throws Exception {
        int[] array = new int[] { 1, 6, 9, 5, 3, 7, 2 };

        LinkedList list = new LinkedList(array);

        assertEquals(2, list.indexFromTheBack(0));
        assertEquals(3, list.indexFromTheBack(2));
        assertEquals(-1, list.indexFromTheBack(100));
        assertEquals(6, list.indexFromTheBack(5));
    }

    @Test
    public void testIndexFromBackWithoutSize() throws Exception {
        int[] array = new int[] { 1, 6, 9, 5, 3, 7, 2 };

        LinkedList list = new LinkedList(array);

        assertEquals(2, list.indexOfFromTheBack(0));
        assertEquals(3, list.indexOfFromTheBack(2));
        assertEquals(-1, list.indexOfFromTheBack(100));
        assertEquals(6, list.indexOfFromTheBack(5));
    }

    // 2.3
    @Test
    public void testDeleteMiddleNode() throws Exception {
        int[] expected = new int[] { 1, 3, 4, 5};
        list.deleteMiddleNode(1);
        assertArrayEquals(expected, list.toIntArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void attemptToDeleteNotMiddleNodeThrowsException() {
        list.deleteMiddleNode(5);
    }
}