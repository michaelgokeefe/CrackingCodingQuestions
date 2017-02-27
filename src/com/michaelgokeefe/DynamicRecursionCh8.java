package com.michaelgokeefe;

/**
 * Created by Michael on 2/27/17.
 */
public class DynamicRecursionCh8 {

    // 8.1
    public static int numWays(int n) {
        return numWays(n, new int[n + 1]);
    }

    private static int numWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = numWays(n - 3, memo) + numWays(n - 2, memo) + numWays(n - 1, memo);

        return memo[n];
    }
}
