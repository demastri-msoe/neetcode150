/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/23/2023
 */
package leetcode.arraysandhashinng;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target, return indices
 * of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you
 * may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 */
public class TwoSum {

    /**
     * intro to the hashing method of managing the diff value
     *
     * @param nums
     * @param target
     * @return index values of items that sum to the target
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currDiff = target - nums[i];
            if (diff.containsKey(currDiff)) {
                return new int[] {i, diff.get(currDiff)};
            } else {
                diff.put(nums[i], i);
            }
        }
        return null;
    }
}
