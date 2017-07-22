package com.michaelgokeefe.chapter4;

import com.michaelgokeefe.chapter4.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/26/17.
 */
public class GraphTest {
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

        Graph notConnect = new Graph(oneTwoNotConnected);
        assertEquals(false, notConnect.areNodesConnected(notConnect.getNodeById(1), notConnect.getNodeById(2)));

        Graph connected = new Graph(oneTwoConnected);
        assertEquals(true, connected.areNodesConnected(connected.getNodeById(1), connected.getNodeById(2)));

    }

}