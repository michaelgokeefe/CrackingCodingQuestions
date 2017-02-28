package com.michaelgokeefe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/28/17.
 */
public class ModerateCh16Test {
    @Test
    public void swap() throws Exception {

        assertEquals(true, ModerateCh16.swap(7, 5));
        assertEquals(true, ModerateCh16.swap(-8, 10));
    }

}