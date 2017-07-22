package com.michaelgokeefe.chapter4;

import org.junit.Test;

/**
 * Created by Michael on 2/26/17.
 */
public class BSTreeTest {
    @Test
    public void constructMinHeightBST() throws Exception {
        BSTree tree = new BSTree();

        int[] elements = new int[] {1, 5, 6, 7, 10, 35};
        BSTree.BSTNode root = tree.constructMinHeightBST(elements);

        tree.printInOrderTraversal(root);
    }

}