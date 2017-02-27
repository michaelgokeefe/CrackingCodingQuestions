package com.michaelgokeefe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/26/17.
 */
public class BitManipulationCh5Test {

    @Test
    public void insertBits() throws Exception {
        assertEquals(12, BitManipulationCh5.insertBits(14, 2, 1, 2));
    }

}