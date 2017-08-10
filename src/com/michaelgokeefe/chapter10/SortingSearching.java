package com.michaelgokeefe.chapter10;

/**
 * Created by Michael on 2/27/17.
 */
public class SortingSearching {
    // quick sort practice
    // o(log n) space
    // o(n * log n) ave case
    // o(n^2) worst case - bad pivot point
    public static void quickSort(int[] array) {

    }

    // merge sort practice
    // o(n) space
    // o(n * log(n)) worst and ave case
    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    private static void merge(int[] array, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int leftHelper = low;
        int rightHelper = middle + 1;
        int current = low;

        while (leftHelper <= middle && rightHelper <= high) {
            if (helper[leftHelper] <= helper[rightHelper]) {
                array[current] = helper[leftHelper];
                leftHelper++;
            } else {
                array[current] = helper[rightHelper];
                rightHelper++;
            }
            current++;
        }

        int remaining = middle - leftHelper;    // only for left side - right side is in place
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[leftHelper + i];
        }
    }

    // 10.1
    public static void merge(int[] a, int[] b, int endA) {

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
}
