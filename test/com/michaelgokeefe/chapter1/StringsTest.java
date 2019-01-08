package com.michaelgokeefe.chapter1;

import com.michaelgokeefe.chapter1.Strings;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Michael on 1/4/17.
 */
public class StringsTest {

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
        assertEquals(true, Strings.isUniqueWithSet(s1));
        assertEquals(false, Strings.isUniqueWithSet(s2));
        assertEquals(false, Strings.isUniqueWithSet(s3));
        assertEquals(true, Strings.isUniqueWithSet(s4));
        assertEquals(false, Strings.isUniqueWithSet(s5));
    }

    @Test
    public void isUniqueWithHashtable() throws Exception {
        assertEquals(true, Strings.isUniqueWithHashTable(s1));
        assertEquals(false, Strings.isUniqueWithHashTable(s2));
        assertEquals(false, Strings.isUniqueWithHashTable(s3));
        assertEquals(true, Strings.isUniqueWithHashTable(s4));
        assertEquals(false, Strings.isUniqueWithHashTable(s5));
    }

    @Test
    public void checkPermutation() throws Exception {
        assertEquals(true, Strings.checkPermutation(s6, s7));
        assertEquals(true, Strings.checkPermutation(s8, s9));
        assertEquals(false, Strings.checkPermutation(s7, s10));
    }

    @Test
    public void testReplaceSpaces() throws Exception {
        String inputStr =  "Mr John Smith    ";
        String outputStr = "Mr%20John%20Smith";

        assertEquals(outputStr, new String(Strings.replaceSpaces(inputStr.toCharArray(), 13)));
    }

    @Test
    public void testIsPalidromePermutation() throws Exception {
        String yes = "TtyYLlo";
        String no = "TtyYLloohhhy";

        assertEquals(false, Strings.isPalindromePermutation(no));
        assertEquals(true, Strings.isPalindromePermutation(yes));
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

        assertEquals(true, Strings.isOneAway(yes1, yes2));
        assertEquals(true, Strings.isOneAway(yes3, yes4));
        assertEquals(false, Strings.isOneAway(no1, no2));
        assertEquals(false, Strings.isOneAway(no3, no4));
    }

    // 1.6
    @Test
    public void testStringCompression() {
        testCompression("", "");
        testCompression("hi", "hi");
        testCompression("hiii", "h1i3");
        testCompression("hii", "hii");
        testCompression("miiiichhhhaeeeel", "m1i4c1h4a1e4l1");
    }

    private void testCompression(String toCompress, String expectedResult) {
        assertEquals(expectedResult, Strings.compressString(toCompress));
    }

    // 1.9
    @Test
    public void testIsRotation() {
        assertTrue(Strings.isRotation("waterbottle", "erbottlewat"));
        assertTrue(Strings.isRotation("plexplexplexington", "lexplexingtonplexp"));
        assertTrue(Strings.isRotation("", ""));
        assertTrue(Strings.isRotation("a", "a"));
        assertTrue(Strings.isRotation("water", "water"));
        assertFalse(Strings.isRotation("water" ,"wate"));
    }
}