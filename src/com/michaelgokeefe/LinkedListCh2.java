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


}
