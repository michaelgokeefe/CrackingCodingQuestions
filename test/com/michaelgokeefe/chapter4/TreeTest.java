package com.michaelgokeefe.chapter4;

import com.michaelgokeefe.chapter4.Tree;
import org.junit.Test;

/**
 * Created by Michael on 2/26/17.
 */
public class TreeTest {
    @Test
    public void constructMinHeightBST() throws Exception {
        Tree tree = new Tree();

        int[] elements = new int[] {1, 5, 6, 7, 10, 35};
        Tree.BSTNode root = tree.constructMinHeightBST(elements);

        tree.printInOrderTraversal(root);
    }

}