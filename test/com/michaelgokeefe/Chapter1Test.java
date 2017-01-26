package com.michaelgokeefe;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Michael on 1/4/17.
 */
public class Chapter1Test {

    String s1 = "m";
    String s2 = "ee";
    String s3 = "efghje";
    String s4 = "qwertyu";
    String s5 = "wertyioo";

    String s6 = "apple";
    String s7 = "papel";
    String s8 = "pppp";
    String s9 = "pppp";
    String s10 = "apply";

    @Test
    public void isUniqueWithSet() throws Exception {
        assertEquals(true, Chapter1.isUniqueWithSet(s1));
        assertEquals(false, Chapter1.isUniqueWithSet(s2));
        assertEquals(false, Chapter1.isUniqueWithSet(s3));
        assertEquals(true, Chapter1.isUniqueWithSet(s4));
        assertEquals(false, Chapter1.isUniqueWithSet(s5));
    }

    @Test
    public void isUniqueWithHashtable() throws Exception {
        assertEquals(true, Chapter1.isUniqueWithHashTable(s1));
        assertEquals(false, Chapter1.isUniqueWithHashTable(s2));
        assertEquals(false, Chapter1.isUniqueWithHashTable(s3));
        assertEquals(true, Chapter1.isUniqueWithHashTable(s4));
        assertEquals(false, Chapter1.isUniqueWithHashTable(s5));
    }

    @Test
    public void checkPermutation() throws Exception {
        assertEquals(true, Chapter1.checkPermutation(s6, s7));
        assertEquals(true, Chapter1.checkPermutation(s8, s9));
        assertEquals(false, Chapter1.checkPermutation(s7, s10));
    }

    @Test
    public void testReplaceSpaces() throws Exception {
        String inputStr =  "Mr John Smith    ";
        String outputStr = "Mr%20John%20Smith";

        assertEquals(outputStr, new String(Chapter1.replaceSpaces(inputStr.toCharArray(), 13)));
    }

    @Test
    public void testIsPalidromePermutation() throws Exception {
        String yes = "TtyYLlo";
        String no = "TtyYLloohhhy";

        assertEquals(false, Chapter1.isPalindromePermutation(no));
        assertEquals(true, Chapter1.isPalindromePermutation(yes));
    }

    @Test
    public void testIsOneAway() throws Exception {
        String yes1 = "pale";
        String yes2 = "ple";

        String yes3 = "bucket";
        String yes4 = "buckit";

        String no1 = "";
        String no2 = "sdflk";

        String no3 = "bucket";
        String no4 = "bckit";

        assertEquals(true, Chapter1.isOneAway(yes1, yes2));
        assertEquals(true, Chapter1.isOneAway(yes3, yes4));
        assertEquals(false, Chapter1.isOneAway(no1, no2));
        assertEquals(false, Chapter1.isOneAway(no3, no4));
    }



}