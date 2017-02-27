package com.michaelgokeefe;

import apple.laf.JRSUIUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/26/17.
 */
public class TreeCh4Test {
    @Test
    public void constructMinHeightBST() throws Exception {
        TreeCh4 tree = new TreeCh4();

        int[] elements = new int[] {1, 5, 6, 7, 10, 35};
        TreeCh4.BSTNode root = tree.constructMinHeightBST(elements);

        tree.printInOrderTraversal(root);
    }

}