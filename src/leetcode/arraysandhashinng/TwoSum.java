package leetcode.arraysandhashinng;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currDiff = target - nums[i];
            if (diff.containsKey(currDiff))
                return new int[]{i, diff.get(currDiff)};
            else
                diff.put(nums[i], i);
        }
        return null;
    }
}
