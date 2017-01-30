package com.michaelgokeefe;

import java.util.HashSet;

/**
 * Created by Michael on 1/27/17.
 */
public class LinkedListCh2 {

    private Node head = null;
    private Node back = null;
    private int size = 0;

    private class Node {
        int data;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    LinkedListCh2(int[] initValues) {
        for (int i = 0; i < initValues.length; i++) {
            addNode(initValues[i]);
        }
    }

    public void addNode(int data) {
        Node node = new Node(data);
        size++;

        if (head == null) {
            head = node;
            back = node;
            return;
        }

        back.next = node;
        back = node;
    }

    // Used for testing
    public int[] toIntArray() {
        int[] array = new int[size];

        Node curr = head;

        int index = 0;
        while (curr != null) {
            array[index] = curr.data;
            curr = curr.next;
            index++;
        }
        return array;
    }

    // 2.1
    public void removeDups() {

        Node bPtr = head;
        Node fPtr = bPtr;

        HashSet<Integer> set = new HashSet<>();

        while (fPtr != null) {
            if (!set.add(fPtr.data)) {
                bPtr.next = fPtr.next;
                fPtr = fPtr.next;
                size--;
            } else {
                bPtr = fPtr;
                fPtr = bPtr.next;
            }
        }
        back = bPtr;
    }

    // 2.2 - solving assuming there is no back of the list reference
    // k = 0 references the back of the list, k = 1 references the seconded node from the back, and so on
    public int indexFromTheBack(int k) {
        if (k >= size || k < 0) {
            return -1;
        }

        int count = size - k - 1;
        Node curr = head;

        while (count > 0) {
            curr = curr.next;
            count--;
        }

        return curr.data;
    }

    // 2.2 - assuming no size reference
    public int indexOfFromTheBack(int index) {
        if (index < 0) {
            return -1;
        }

        Node curr = head;
        Node runner = head;

        while (index > 0) {
            if (runner.next != null) {
                index--;
                runner = runner.next;
            } else {
                return -1;
            }
        }
        while (runner.next != null) {
            runner = runner.next;
            curr = curr.next;
        }

        return curr.data;
    }

    


}
