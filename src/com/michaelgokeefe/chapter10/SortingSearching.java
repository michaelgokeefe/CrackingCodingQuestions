package com.michaelgokeefe.chapter10;

/**
 * Created by Michael on 2/27/17.
 */
public class SortingSearching {
    // merge sort practice
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

        int remaining = middle - leftHelper;
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
