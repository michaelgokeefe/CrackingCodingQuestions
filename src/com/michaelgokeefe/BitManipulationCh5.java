package com.michaelgokeefe;

/**
 * Created by Michael on 2/26/17.
 */
public class BitManipulationCh5 {

    public static int insertBits(int N, int M, int i, int j) {
        if (j - i > 32) { throw new IllegalArgumentException("Only 32 bits supported."); }

        // Clear i and j gap within N
        int leftMask = -1 << i;
        int rightMask = -1 >>> (32 - j);

        int mask = ~(leftMask & rightMask);

        N &= mask;

        // Shift M over i
        M <<= i;

        // Insert M into N
        return M | N;
    }
}
