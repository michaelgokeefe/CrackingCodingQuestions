package com.michaelgokeefe.chapter5;

import com.michaelgokeefe.chapter5.BitManipulation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/26/17.
 */
public class BitManipulationTest {

    // 5.1
    @Test
    public void insertBits() throws Exception {
        assertEquals(12, BitManipulation.insertBits(14, 2, 1, 2));
    }

    // 5.2
    @Test
    public void toBinaryString() throws Exception {
        assertEquals(".1", BitManipulation.toBinaryString(.5));
        assertEquals(".01", BitManipulation.toBinaryString(.25));
        assertEquals(BitManipulation.ERROR, BitManipulation.toBinaryString(.72));
    }

    // get bit
    @Test
    public void getBit_AllZeros() {
        assertEquals(false, BitManipulation.getBit(0, 11));
    }

    @Test
    public void getBit_OverThirtyTwoShifts() {
        assertEquals(false, BitManipulation.getBit(12345, 33));
    }

    @Test
    public void getBit_ExpectedTrues() {
        assertEquals(true, BitManipulation.getBit(1, 32));
    }

    // set bit
    @Test
    public void setBit_ZeroToOne() {
        assertEquals(1, BitManipulation.setBit(0, 0));
    }

    @Test
    public void setBit_ThreeToSeven() {
        assertEquals(7, BitManipulation.setBit(3, 2));
    }

    // clear bit
    @Test
    public void clearBit_OneToZero() {
        assertEquals(0, BitManipulation.clearBit(1, 0));
    }

    @Test
    public void clearBit_SevenToThree() {
        assertEquals(3, BitManipulation.clearBit(7, 2));
    }

    // clear MSB through index
    @Test
    public void clearMSBthroughI_FifteenToThree() {
        assertEquals(3, BitManipulation.clearMSBthroughI(15, 2));
    }

    // clear 0 bit through index
    @Test
    public void clear0BitThroughI_SevenToFour() {
        assertEquals(4, BitManipulation.clear0BitThroughI(7, 1));
    }

    // update bit
    @Test
    public void updateBit_ZeroToOne() {
        assertEquals(1, BitManipulation.updateBit(0, 0, true));
    }
}