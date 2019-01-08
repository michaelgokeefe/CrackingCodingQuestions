package com.michaelgokeefe.chapter1;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Michael on 1/4/17.
 */
public class Strings {

    // 1.1
    public static boolean isUniqueWithSet(String toCheck) {
        Set<Character> set = new TreeSet<Character>();
        for (int i = 0; i < toCheck.length(); i++) {
            if (!set.add(toCheck.charAt(i))) {
                return false;
            }
        }
        return toCheck.length() == set.size();
    }

    public static boolean isUniqueWithHashTable(String toCheck) {
        boolean[] letters = new boolean[128];
        for (int i = 0; i < toCheck.length(); i++) {
            int index = (int) toCheck.charAt(i);
            if (letters[index]) {
                return false;
            } else {
                letters[index] = true;
            }
        }
        return true;
    }

    // 1.2
    public static boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        // assuming an empty string is a permutation of an empty string
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            Character key = s1.charAt(i);
            Integer value = map.get(key);
            if (value != null) {
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            Character key = s2.charAt(i);
            Integer value = map.get(key);
            if (value == null || value == 0) {
                return false;
            }
            map.put(key, --value);
        }
        return true;
    }

    // 1.3
    public static char[] replaceSpaces(char[] org, int size) {
        if (org == null) {
            return null;
        }

        if (size > org.length || size < 0) {
            System.err.println("Given size is invalid: " + size);
            return org;
        }

        if (org.length == size) {
            return org;
        }

        char[] url = new char[org.length];
        int ptr = 0;
        for (int i = 0; i < size; i++) {
            char curr = org[i];
            if (curr == ' ') {
                url[ptr++] = '%';
                url[ptr++] = '2';
                url[ptr++] = '0';
            } else {
                url[ptr++] = curr;
            }
        }
        return url;
    }

    // 1.4
    public static boolean isPalindromePermutation(String val) {
        if (val == null) {
            return false;
        }

        int[] freq = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];


        int oddCount = 0;

        for (int i = 0; i < val.length(); i++) {
            char curr = val.charAt(i);

            int index = getCharNumber(curr);

            if (index < 0) {
                continue;
            }

            if (curr == ' ') {
                continue;
            }

            int currFreq = ++freq[index];

            if (currFreq % 2 == 1) {
                oddCount++;
            } else {
                oddCount--;
            }
        }
        return oddCount <= 1;
    }

    // 1.4 - bit vector version, assumes only english words (case insensitive)
    public static boolean isPalPermWithBitVector(String val) {
        int bitVector = createBitVector(val);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    private static int createBitVector(String val) {
        int bitVector = 0;
        for (char c : val.toCharArray()) {
            int index = getCharNumber(c);
            bitVector = toggle(bitVector, index);
        }
        return bitVector;
    }

    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    private static int toggle(int bitVector, int index) {
        if (index < 0) {
            return bitVector;
        }

        int mask = 1 << index;

        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    private static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    // 1.5
    public static boolean isOneAway(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        } else if (s1.length() > s2.length()) {
            return  isOneInsertAway(s1, s2);
        } else if (s1.length() < s2.length()) {
            return isOneInsertAway(s2, s1);
        } else {
            return isOneReplaceAway(s1, s2);
        }
    }

    private static boolean isOneReplaceAway(String s1, String s2) {
        boolean oneDiff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (!oneDiff) {
                    oneDiff = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isOneInsertAway(String longStr, String shortStr) {
        boolean oneDiff = false;
        for (int i = 0; i < shortStr.length(); i++) {
            if (!oneDiff) {
                if (shortStr.charAt(i) != longStr.charAt(i)) {
                    oneDiff = true;
                }
            } else {
                if (shortStr.charAt(i - 1) != longStr.charAt(i)) {
                    return false;
                }
            }
        }
        return !oneDiff || shortStr.charAt(shortStr.length() - 1) == longStr.charAt(longStr.length() - 1);
    }

    // 1.6
    public static String compressString(String str) {
        if (str.length() < 2) {
            return str;
        }

        String compressedString = getCompressedString(str);

        if (compressedString.length() > str.length()) {
            return str;
        }
        return compressedString;
    }

    private static String getCompressedString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        char prevChar = str.charAt(0);
        for (char currChar : str.toCharArray()) {
            if (prevChar == currChar) {
                count++;
            } else {
                stringBuilder.append(prevChar);
                stringBuilder.append(count);
                prevChar = currChar;
                count = 1;
            }
        }
        stringBuilder.append(prevChar);
        stringBuilder.append(count);

        return stringBuilder.toString();
    }


    // 1.9 - String Rotation - 1/7/2019
    // 0(n) time
    // Note: can be done more simply by performing isSubstring(s1 + s1, s2) along with the necessary null/length checks
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        if (s1.length() == 0) return true;

        int i1 = 0, i2 = 0;

        StringBuilder head = new StringBuilder();
        StringBuilder tail = new StringBuilder();

        for (; i2 < s2.length(); i2++) {
            char c = s2.charAt(i2);
            if (c == s1.charAt(i1)) {
                i1++;
                head.append(c);
            } else {
                i1 = 0;
                if (head.length() != 0) {
                    tail.append(head.toString());
                    head.setLength(0);
                }
                tail.append(c);
            }
        }

        if (head.length() == 0) return false;
        else if (head.length() == s1.length()) return true;

        // Works as isSubstring(s1, tail);
        String expectedTail = s1.substring(i1, s1.length());
        return expectedTail.equals(tail.toString());
    }
}
