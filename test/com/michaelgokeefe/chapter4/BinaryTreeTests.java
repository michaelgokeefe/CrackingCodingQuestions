package com.michaelgokeefe.chapter4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BinaryTreeTests {
    private BinaryTree<Integer> tree;

    // 4.3
    @Test
    public void listOfDepths_ReturnsEmptyListWhenTreeIsEmpty() {
        tree = new BinaryTree<>(new Integer[0]);
        assertEquals(true, tree.getListOfDepths().isEmpty());
    }

    @Test
    public void listOfDepths_OneLevelEqualsOneLinkedList() {
        Integer[] elements = new Integer[] { 1 };
        tree = new BinaryTree<>(elements);
        assertListOfDepthsIsValid(elements);
    }

    @Test
    public void listOfDepths_TwoLevelsCompleteTree() {
        Integer[] elements = new Integer[] { 1, 2, 3 };
        tree = new BinaryTree<>(elements);
        assertListOfDepthsIsValid(elements);
    }

    @Test
    public void listOfDepths_MultiLevelsCompleteTree() {
        Integer[] elements = new Integer[] { 10, 55, 45, 456, 753, 86, -5, 65, 567, 2546, 345, 1 };
        tree = new BinaryTree<>(elements);
        assertListOfDepthsIsValid(elements);
    }

    private void assertListOfDepthsIsValid(Integer[] expectedElements) {
        List<LinkedList<Integer>> depths = tree.getListOfDepths();
        ArrayList<Integer> actualElements = new ArrayList<>();
        for (LinkedList<Integer> depthList : depths) {
            for (Integer value : depthList) {
                actualElements.add(value);
            }
        }
        assertArrayEquals(expectedElements, actualElements.toArray());
    }
}
