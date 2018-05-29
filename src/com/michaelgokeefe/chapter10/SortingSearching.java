package com.michaelgokeefe.chapter10;

/**
 * Created by Michael on 2/27/17.
 */
public class SortingSearching {
    public static void mergeArrays(int[] a, int[] b, int endA) {

        if (a == null || b == null || endA < 0) {
            throw new IllegalArgumentException();
        }

        int mergeIndex = a.length - 1;
        int aIndex = endA;
        int bIndex = b.length - 1;

        while (bIndex >= 0) {

            if (aIndex >= 0 && a[aIndex] > b[bIndex]) {
                a[mergeIndex] = a[aIndex];
                aIndex--;
            } else {
                a[mergeIndex] = b[bIndex];
                bIndex--;
            }
            mergeIndex--;
        }
    }

    // merge sort - 2018

    public static void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    private static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(array, helper, low, mid);
            mergesort(array, helper, mid + 1, high);
            merge(array, helper, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] helper, int low, int mid, int high) {
        // Copy sorted halves to helper
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLow = low;
        int helperHigh = mid + 1;
        int current = low;

        while (helperLow <= mid && helperHigh <= high) {
            if (helper[helperLow] <= helper[helperHigh]) {
                array[current] = helper[helperLow++];
            } else {
                array[current] = helper[helperHigh++];
            }
            current++;
        }

        int remaining = mid - helperLow;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLow + i];
        }
    }
}
