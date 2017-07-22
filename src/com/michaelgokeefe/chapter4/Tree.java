package com.michaelgokeefe.chapter4;

/**
 * Created by Michael on 2/26/17.
 */
public class Tree {

    public class BSTNode {
        int data;
        BSTNode left = null;
        BSTNode right = null;

        BSTNode(int data) {
            this.data = data;
        }

        void setLeft(BSTNode leftNode) {
            this.left = leftNode;
        }

        void setRight(BSTNode rightNode) {
            this.right = rightNode;
        }

        @Override
        public String toString() {
            return "" + this.data + " ";
        }
    }

    public void printInOrderTraversal(BSTNode node) {
        if (node == null) {
            return;
        }
        printInOrderTraversal(node.left);
        System.out.println(node);
        printInOrderTraversal(node.right);
    }

    // 4.2
    // elements assumed to be sorted (ascending order) and contain no duplicates
    public BSTNode constructMinHeightBST(int[] elements) {
        return constructMinHeightBSTHelper(elements, 0, elements.length - 1);
    }

    private BSTNode constructMinHeightBSTHelper(int[] elements, int low, int high) {
        if (high < low) {
            return null;
        }

        int mid = (high + low) / 2;

        BSTNode node = new BSTNode(elements[mid]);
        node.setLeft(constructMinHeightBSTHelper(elements, low, mid - 1));
        node.setRight(constructMinHeightBSTHelper(elements, mid + 1, high));
        return node;
    }
}
