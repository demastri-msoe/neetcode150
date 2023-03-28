package leetcode.intervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntervalsTest {
    @Test
    public void insertIntervalTest() {
        InsertInterval o = new InsertInterval();

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] expected = new int[][]{{1, 5}, {6, 9}};

        int[][] outIntervals = o.insert(intervals, newInterval);
        Assertions.assertNotNull(outIntervals);
        Assertions.assertEquals(expected.length, outIntervals.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], outIntervals[i]);
        }

        intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        newInterval = new int[]{4, 8};
        expected = new int[][]{{1, 2}, {3, 10}, {12, 16}};
        outIntervals = o.insert(intervals, newInterval);
        Assertions.assertNotNull(outIntervals);
        Assertions.assertEquals(expected.length, outIntervals.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], outIntervals[i]);
        }
        intervals = new int[][]{};
        newInterval = new int[]{5, 7};
        expected = new int[][]{{5, 7}};
        outIntervals = o.insert(intervals, newInterval);
        Assertions.assertNotNull(outIntervals);
        Assertions.assertEquals(expected.length, outIntervals.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], outIntervals[i]);
        }

        intervals = new int[][]{{1, 5}};
        newInterval = new int[]{2, 7};
        expected = new int[][]{{1, 7}};
        outIntervals = o.insert(intervals, newInterval);
        Assertions.assertNotNull(outIntervals);
        Assertions.assertEquals(expected.length, outIntervals.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], outIntervals[i]);
        }

        intervals = new int[][]{{1, 5}};
        newInterval = new int[]{6, 8};
        expected = new int[][]{{1, 5}, {6, 8}};
        outIntervals = o.insert(intervals, newInterval);
        Assertions.assertNotNull(outIntervals);
        Assertions.assertEquals(expected.length, outIntervals.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], outIntervals[i]);
        }

        intervals = new int[][]{{1, 5}};
        newInterval = new int[]{0, 3};
        expected = new int[][]{{0, 5}};
        outIntervals = o.insert(intervals, newInterval);
        Assertions.assertNotNull(outIntervals);
        Assertions.assertEquals(expected.length, outIntervals.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], outIntervals[i]);
        }

        intervals = new int[][]{{1, 5}};
        newInterval = new int[]{0, 6};
        expected = new int[][]{{0, 6}};
        outIntervals = o.insert(intervals, newInterval);
        Assertions.assertNotNull(outIntervals);
        Assertions.assertEquals(expected.length, outIntervals.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], outIntervals[i]);
        }

        intervals = new int[][]{{3, 5}, {12,15}};
        newInterval = new int[]{6, 6};
        expected = new int[][]{{3,5}, {6, 6}, {12,15}};
        outIntervals = o.insert(intervals, newInterval);
        Assertions.assertNotNull(outIntervals);
        Assertions.assertEquals(expected.length, outIntervals.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], outIntervals[i]);
        }
    }
}
