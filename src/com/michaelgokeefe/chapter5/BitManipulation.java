package com.michaelgokeefe.chapter5;

/**
 * Created by Michael on 2/26/17.
 */
public class BitManipulation {

    public static final String ERROR = "ERROR";

    // 5.1
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

    // 5.2
    public static String toBinaryString(double num) {
        if (num >= 1 || num <= 0) {
            return ERROR;
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");

        while (num > 0) {
            if (binary.length() >= 32) {
                return ERROR;
            }

            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static boolean getBit(int num, int index) {
        int bit = 1 << index;
        return (bit & num) != 0;
    }

    public static int setBit(int num, int index) {
        int bit = 1 << index;
        return (bit | num);
    }

    public static int clearBit(int num, int index) {
        int mask = ~(1 << index);
        return (num & mask);
    }

    public static int clearMSBthroughI(int num, int index) {
        int mask = (1 << index) - 1;
        return (num & mask);
    }

    public static int clear0BitThroughI(int num, int index) { // -1 is a sequence of all 1's
        int mask = -1 << index + 1;
        return (num & mask);
    }

    public static int updateBit(int num, int index, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << index);
        return (num & mask) | (value << index);
    }
}
