/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/23/2023
 */
package leetcode.binarysearch;

/**
 * https://leetcode.com/problems/binary-search/
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index.
 * Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {


    /**
     * search sorted array - simple index manipulation for binary search
     *
     * @param nums
     * @param target
     * @return index of the target or -1
     */
    public int search(int[] nums, int target) {
        int lowLim = 0;
        int highLim = nums.length;
        int probe = nums.length / 2;

        while (nums[probe] != target) {
            if (nums[probe] > target) {
                highLim = probe;
            } else {
                lowLim = probe;
            }
            int oldProbe = probe;
            probe = (highLim + lowLim) / 2;
            if (probe == oldProbe) {
                return -1;
            }
        }

        return probe;
    }
}
