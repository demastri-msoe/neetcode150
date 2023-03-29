/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/26/2023
 */
package leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 *
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith interval
 * and intervals is sorted in ascending order by starti. You are also given an interval
 * newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by
 * starti and intervals still does not have any overlapping intervals (merge overlapping
 * intervals if necessary).
 *
 * Return intervals after the insertion.
 */
public class InsertInterval {
    /**
     * Couple of edge cases -
     * if new.high > first.low, prepend new to existing list
     * if new.low > last.high, append new to existing list
     * <p>
     * in the normal case, keep a "building" var if we've found the low end of the range
     * building = false.
     * <p>
     * for each elt in the list -> curElt
     * if !building && (new.high < cur.low || new.low > cur.high, output curElt
     * if !building && new.low is in the inclusive range of cur, low =
     *      min(cur.low, new.low), set building = true
     * if building, three cases -
     * 1 - high is in this range - output [low, max(range.high, new.high)] - building = false
     * 2 - high is above this range (do nothing more, get next), leave building = true
     * 3 - high is below this range - output [low, new.high] AND curElt - building = false
     * <p>
     * if building after the loop, output [lowVal, new.high]
     *
     * @param intervals
     * @param newInterval
     * @return set of intervals with new one inserted
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        List<int[]> outIntervals = new ArrayList<>();
        boolean written = false;
        boolean building = false;

        int newLo = newInterval[0];
        int newHi = newInterval[1];

        int lowBound = -1;
        int highBound = -1;

        for (int[] curInterval : intervals) {
            int eltLo = curInterval[0];
            int eltHi = curInterval[1];

            if (written) {
                outIntervals.add(curInterval);
                continue;
            }

            if (!building && eltHi < newLo) {
                outIntervals.add(curInterval);
                continue;
            }
            if (!building && eltLo < newLo && newHi <= eltHi) {
                outIntervals.add(curInterval);
                written = true;
                continue;
            }
            if (!building && eltLo > newHi) {
                outIntervals.add(newInterval);
                outIntervals.add(curInterval);
                written = true;
                continue;
            }
            if (!building && eltLo <= newHi) {
                lowBound = eltLo < newLo ? eltLo : newLo;
                highBound = eltHi > newHi ? eltHi : newHi;
                building = true;
            }
            if (building) {
                if (eltLo <= highBound) {
                    highBound = eltHi > newHi ? eltHi : newHi;
                } else {
                    outIntervals.add(new int[] {lowBound, highBound});
                    outIntervals.add(curInterval);
                    written = true;
                    building = false;
                }
            }
        }
        if (building) {
            outIntervals.add(new int[] {lowBound, highBound});
            written = true;
        }
        if (!written) {
            outIntervals.add(newInterval);
        }
        int[][] outArr = new int[outIntervals.size()][2];
        for (int i = 0; i < outIntervals.size(); i++) {
            outArr[i][0] = outIntervals.get(i)[0];
            outArr[i][1] = outIntervals.get(i)[1];
        }
        return outArr;
    }
}
