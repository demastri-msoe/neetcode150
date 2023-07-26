/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/30/2023
 */
package leetcode.greedy;

/**
 * https://leetcode.com/problems/jump-game/
 * <p>
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {

    /**
     * This is a greedy solution...
     * <p>
     * See how far you can go at any step (if you can get there to begin with)
     * Ensure max for list is at least as large as the list...
     *
     * @param nums max step possible at each location
     * @return t if you can get to the end.
     */
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int curMax = 0;
        for (int i = 0; i < nums.length - 1 && curMax < nums.length - 1 && curMax >= i; i++) {
            if (curMax < i + nums[i]) {
                curMax = i + nums[i];
            }
        }
        return curMax >= nums.length - 1;
    }

    /**
     * This is a DP solution...
     * <p>
     * Pretty interesting - if all are non-zero, you can clearly get to the end
     * 0s are blockers.  go back from the end.  at every 0 look for a prior node
     * that can jump over this index.  if none-you can't get there.
     * iterate to the beginning
     *
     * @param nums max step possible at each location
     * @return t if you can get to the end.
     */
    public boolean canJumpDP(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int curBlockingZero = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (curBlockingZero >= 0) {
                if (i + nums[i] > curBlockingZero ||
                        i + nums[i] == curBlockingZero && curBlockingZero == nums.length - 1) {
                    curBlockingZero = -1;
                }
            } else if (nums[i] == 0) {
                curBlockingZero = i;
            }
        }
        return curBlockingZero == -1;
    }
}
