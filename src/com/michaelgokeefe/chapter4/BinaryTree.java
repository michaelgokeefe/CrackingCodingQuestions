package com.michaelgokeefe.chapter4;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree<T> {

    private class TreeNode {
        T data;
        TreeNode left;
        TreeNode right;

        TreeNode(T data) {
            this.data = data;
        }
    }

    private TreeNode root;

    public BinaryTree(T[] elements) {
        root = constructBinaryTree(elements, 1);
    }



    private TreeNode constructBinaryTree(T[] elements, int index) {
        if (index > elements.length) {
            return null;
        }

        TreeNode node = new TreeNode(elements[index - 1]);
        node.left = constructBinaryTree(elements, index * 2);
        node.right = constructBinaryTree(elements, index * 2 + 1);
        return node;
    }

    // 4.3
    public ArrayList<LinkedList<T>> getListOfDepths() {
        ArrayList<LinkedList<T>> listOfDepths = new ArrayList<>();
        getListOfDepths(root, listOfDepths, 0);
        return listOfDepths;
    }

    private void getListOfDepths(TreeNode node, ArrayList<LinkedList<T>> listOfDepths, int level) {
        if (node == null) {
            return;
        }

        LinkedList<T> elements;
        if (listOfDepths.size() - 1 < level) {
            elements = new LinkedList<>();
            listOfDepths.add(level, elements);
        } else {
            elements = listOfDepths.get(level);
        }
        elements.add(node.data);

        getListOfDepths(node.left, listOfDepths, level + 1);
        getListOfDepths(node.right, listOfDepths, level + 1);
    }
}
