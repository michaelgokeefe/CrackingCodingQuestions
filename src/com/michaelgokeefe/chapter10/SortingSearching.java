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
            mergeOld(array, helper, low, middle, high);
        }
    }

    private static void mergeOld(int[] array, int[] helper, int low, int middle, int high) {
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
