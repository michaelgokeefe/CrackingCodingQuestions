package com.michaelgokeefe.chapter10;

/**
 * Created by Michael on 2/27/17.
 */
public class SortingSearching {
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
