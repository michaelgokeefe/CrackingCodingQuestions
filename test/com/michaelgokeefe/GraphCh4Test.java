package com.michaelgokeefe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/26/17.
 */
public class GraphCh4Test {
    @Test
    public void areNodesConnected() throws Exception {
        String oneTwoNotConnected = "1 2 3 \n " +
                                    "1 3 \n " +
                                    "2 \n " +
                                    "3 1";

        String oneTwoConnected =    "1 2 3 \n" +
                                    "1 3 \n " +
                                    "2 3\n " +
                                    "3 1 2";

        GraphCh4 notConnect = new GraphCh4(oneTwoNotConnected);
        assertEquals(false, notConnect.areNodesConnected(notConnect.getNodeById(1), notConnect.getNodeById(2)));

        GraphCh4 connected = new GraphCh4(oneTwoConnected);
        assertEquals(true, connected.areNodesConnected(connected.getNodeById(1), connected.getNodeById(2)));

    }

}