package com.michaelgokeefe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/27/17.
 */
public class DynamicRecursionCh8Test {
    @Test
    public void numWays() throws Exception {
        assertEquals(7, DynamicRecursionCh8.numWays(4));
    }

}