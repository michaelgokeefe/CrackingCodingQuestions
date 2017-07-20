package com.michaelgokeefe;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

// 3.3
public class SetOfStacks<T> {
    private final int maxStackCapacity;
    private List<Stack<T>> stacks = new ArrayList<>();
    private int topStackIndex;

    public SetOfStacks(int maxStackCapacity) {
        this.maxStackCapacity = maxStackCapacity;
        Stack<T> firstStack = new Stack<>(maxStackCapacity);
        stacks.add(firstStack);
        topStackIndex = 0;
    }

    public void push(T data) {
        try {
            Stack<T> topStack = stacks.get(topStackIndex);
            topStack.push(data);
        } catch (StackCapacityReachedException e) {
            Stack<T> newTopStack = new Stack<>(maxStackCapacity);
            stacks.add(newTopStack);
            topStackIndex++;
            push(data);
        }
    }

    public T pop() {
        try {
            Stack<T> topStack = stacks.get(topStackIndex);
            return topStack.pop();
        } catch (EmptyStackException e) {
            stacks.remove(topStackIndex);
            if (topStackIndex > 0) {
                topStackIndex--;
                return pop();
            } else {
                throw new EmptyStackException();
            }
        }
    }

    public T popAtIndex(int index) {
        try {
            Stack<T> stackToPop = stacks.get(index);
            return stackToPop.pop();
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }
}
