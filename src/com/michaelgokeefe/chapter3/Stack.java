package com.michaelgokeefe.chapter3;

import java.util.EmptyStackException;

/**
 * Created by Michael on 7/20/17.
 */
public class Stack<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private final int maxCapacity;
    private int size = 0;

    public Stack(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void push(T data) {
        if (size == maxCapacity) {
            throw new StackCapacityReachedException();
        }
        Node newItem = new Node(data);
        Node temp = top;
        top = newItem;
        newItem.next = temp;
        size++;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T topData = top.data;
        top = top.next;
        size--;
        return topData;
    }

}
