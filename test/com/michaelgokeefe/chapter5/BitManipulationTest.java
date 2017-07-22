package com.michaelgokeefe.chapter5;

import com.michaelgokeefe.chapter5.BitManipulation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/26/17.
 */
public class BitManipulationTest {

    @Test
    public void insertBits() throws Exception {
        assertEquals(12, BitManipulation.insertBits(14, 2, 1, 2));
    }

}