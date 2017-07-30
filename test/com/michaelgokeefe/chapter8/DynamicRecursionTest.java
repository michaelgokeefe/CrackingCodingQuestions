package com.michaelgokeefe.chapter8;

import com.michaelgokeefe.chapter8.DynamicRecursion;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Michael on 2/27/17.
 */
public class DynamicRecursionTest {
    //8.1
    @Test
    public void numWays() throws Exception {
        assertEquals(7, DynamicRecursion.numWays(4));
    }

    // 8.2

    private ArrayList<Point> exp = new ArrayList<>();

    @Test
    public void findPath_EmptyPathOnOneByOneGrid() {
        boolean[][] grid = new boolean[1][1];
        assertEquals(exp, DynamicRecursion.findRobotPath(grid));
    }

    @Test
    public void findPath_NoLimitsTwoByTwoGrid() {
        boolean[][] grid = new boolean[][] {{true, true}, {true, true}};
        exp.add(new Point(0, 0));
        exp.add(new Point(0, 1));
        exp.add(new Point(1,1));
        assertEquals(exp, DynamicRecursion.findRobotPath(grid));
    }

    @Test
    public void findPath_OnlyDownNoLimits() {
        boolean[][] grid = new boolean[][] {{true}, {true}};
        exp.add(new Point(0, 0));
        exp.add(new Point(1, 0));
        assertEquals(exp, DynamicRecursion.findRobotPath(grid));
    }

    @Test
    public void findPath_OnlyRightNoLimits() {
        boolean[][] grid = new boolean[][] {{true, true}};
        exp.add(new Point(0, 0));
        exp.add(new Point(0, 1));
        assertEquals(exp, DynamicRecursion.findRobotPath(grid));
    }

    @Test
    public void findPath_ThreeByThreeGridWithMiddleLimit() {
        boolean[][] grid = {{true, true, true}, {true, false, true}, {false, true, true}};
        exp.add(new Point(0, 0));
        exp.add(new Point(0, 1));
        exp.add(new Point(0, 2));
        exp.add(new Point(1, 2));
        exp.add(new Point(2, 2));
        assertEquals(exp, DynamicRecursion.findRobotPath(grid));
    }

    @Test
    public void findPath_NoPath() {
        boolean[][] grid = {{true, true, true}, {true, false, true}, {false, true, false}};
        assertEquals(exp, DynamicRecursion.findRobotPath(grid));
    }

}