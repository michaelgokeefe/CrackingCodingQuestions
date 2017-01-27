package com.michaelgokeefe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 1/27/17.
 */
public class LinkedListCh2Test {
    @Test
    public void removeDups() throws Exception {
        int[] withDups = new int[] { 1, 5, 5, 8, 4, 2, 4, 8, 9, 66, -1, 1 };
        int[] withoutDups = new int[] {1, 5, 8, 4, 2, 9, 66, -1 };

        LinkedListCh2 list = new LinkedListCh2(withDups);

        assertArrayEquals(withDups, list.toIntArray());

        list.removeDups();

        assertArrayEquals(withoutDups, list.toIntArray());
    }

}