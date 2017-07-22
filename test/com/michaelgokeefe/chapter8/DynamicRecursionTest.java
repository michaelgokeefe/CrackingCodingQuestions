package com.michaelgokeefe.chapter8;

import com.michaelgokeefe.chapter8.DynamicRecursion;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/27/17.
 */
public class DynamicRecursionTest {
    @Test
    public void numWays() throws Exception {
        assertEquals(7, DynamicRecursion.numWays(4));
    }

}