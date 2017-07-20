package com.michaelgokeefe;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.EmptyStackException;

// 3.3
public class SetOfStacksTest {
    private SetOfStacks<Integer> stacks = new SetOfStacks<>(5);
    private int[] values = new int[] { 1, 3, 5, 4, 3, 6};
    private int[] manyValues = new int[] { 1, 7, 8, 4, 30, 5430, 5639, 2346, 231, 644, 21 };


    @Test
    public void canPush() {
        stacks.push(1);
    }

    @Test(expected = EmptyStackException.class)
    public void popWhenEmptyThrowsException() {
        stacks.pop();
    }

    @Test
    public void canPushAndPopSameItem() {
        stacks.push(1);
        assertExpectedEqualsPop(1);
    }

    @Test
    public void canSetMaxCapacityOnConstruction() {
        SetOfStacks<Integer> stacks = new SetOfStacks<>(5);
    }

    @Test
    public void canPopAtIndexWithOneStack() {
        stacks.push(1);
        assertExpectedEqualsPopAtIndex(1, 0);
    }

    @Test
    public void canPopAtIndexWithMultipleStacks() {
        pushArrayToStacks(values);
        assertExpectedEqualsPopAtIndex(3, 0);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void exceptionWhenPopingAtInvalidIndex() {
        stacks.popAtIndex(5);
    }

    @Test
    public void testManyPopsAndPushes() {
        pushArrayToStacks(manyValues);
        assertExceptedEqualsPopWithReverseArray(manyValues);
    }

    @Test
    public void testCombosOfPopsAndPopAtIndexes() {
        pushArrayToStacks(manyValues);
        assertExpectedEqualsPopAtIndex(644, 1);
        assertExpectedEqualsPop(21);
        assertExpectedEqualsPopAtIndex(30, 0);
        assertExpectedEqualsPopAtIndex(4, 0);
        assertExpectedEqualsPop(231);
    }

    private void pushArrayToStacks(int[] items) {
        for (int item : items) {
            stacks.push(item);
        }
    }

    private void assertExceptedEqualsPopWithReverseArray(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            assertExpectedEqualsPop(array[i]);
        }
    }


    private void assertExpectedEqualsPopAtIndex(int expected, int index) {
        assertEquals(expected, stacks.popAtIndex(index).intValue());
    }

    private void assertExpectedEqualsPop(int expected) {
        assertEquals(expected, stacks.pop().intValue());
    }
}
