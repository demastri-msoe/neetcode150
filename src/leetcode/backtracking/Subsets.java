/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/29/2023
 */
package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * <p>
 * Given an integer array nums of unique elements, return all possible
 * subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {

    /**
     * This is my favorite algorithm - the secret decoder ring method for generating permutations.
     *
     * @param nums the vals to be permuted
     * @return all of the possible permutations.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outList = new ArrayList<>();
        int limit = nums.length;
        int[] thisPerm = new int[limit];

        // the 0 case
        outList.add(new ArrayList<>());

        for (int s = 1; s <= limit; s++) {
            // seed it
            for (int seed = 0; seed < s; seed++) {
                thisPerm[seed] = seed;
            }
            outList.add(genOutPerm(thisPerm, nums, s));
            int curIndex = s - 1;
            while (curIndex >= 0) {
                // ok this one can get reset
                int curIndexVal = thisPerm[curIndex];
                if (curIndexVal == limit - 1) {
                    curIndex--;
                    continue;
                }
                for (int upd = curIndex; upd < s; upd++) {
                    thisPerm[upd] = ++curIndexVal;
                }
                if (curIndexVal >= limit) {
                    curIndex--;
                    continue;
                }
                curIndex = s - 1;
                outList.add(genOutPerm(thisPerm, nums, s));
            }


        }
        return outList;
    }

    List<Integer> genOutPerm(int[] index, int[] vals, int s) {
        List<Integer> outList = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            outList.add(vals[index[i]]);
        }
        return outList;
    }
}
