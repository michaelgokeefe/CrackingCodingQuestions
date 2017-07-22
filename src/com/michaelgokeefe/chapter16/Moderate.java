package com.michaelgokeefe.chapter16;

/**
 * Created by Michael on 2/28/17.
 */
public class Moderate {

    public static boolean swap(int n, int m) {
        // for testing
        int orgN = n;
        int orgM = m;

        // diff
        n -= m;

        // m = org. n
        m += n;

        // n = org. m
        n = m - n;

        if (orgM != n || orgN != m) {
            return false;
        }
        return true;
    }

}
