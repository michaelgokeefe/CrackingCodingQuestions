package com.michaelgokeefe.chapter16;

import com.michaelgokeefe.chapter16.Moderate;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/28/17.
 */
public class ModerateTest {
    @Test
    public void swap() throws Exception {

        assertEquals(true, Moderate.swap(7, 5));
        assertEquals(true, Moderate.swap(-8, 10));
    }

}