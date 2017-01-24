package com.michaelgokeefe;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Michael on 1/4/17.
 */
public class Chapter1 {

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
}
