package com.michaelgokeefe.chapter8;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Michael on 2/27/17.
 */
public class DynamicRecursion {

    private static final char RIGHT = 'R';
    private static final char DOWN = 'D';

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

    // In any path finding - use breadth before depth ***
    public static ArrayList<Point> findRobotPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException("Empty or null grid.");
        }
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        findRobotPath(grid, path, grid.length -1, grid[0].length - 1, failedPoints);
        return path;
    }

    private static boolean findRobotPath(boolean[][] grid, ArrayList<Point> path, int row, int col, HashSet<Point> failedPoints) {

        // Index OOB or off limits
        if (row < 0 || col < 0 || !grid[row][col]) {
            return false;
        }

        Point point = new Point(row, col);

        if (failedPoints.contains(point)) {
            return false;
        }

        boolean atOrigin = (row == 0) && (col == 0);

        if (atOrigin || findRobotPath(grid, path, row - 1, col, failedPoints) || findRobotPath(grid, path, row, col - 1, failedPoints)) {
            path.add(point);
            return true;
        }
        failedPoints.add(point); // by caching failed points, we reduce the runtime from O(2^r+c) to O(rc) - aka searching each index of the grid
        return false;
    }
}
