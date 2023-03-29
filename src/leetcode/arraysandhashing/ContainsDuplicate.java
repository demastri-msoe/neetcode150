package leetcode.arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> thisSet = new HashSet<Integer>();
        for (int i : nums) {
            if (!thisSet.add(i))
                return true;
        }
        return false;
    }

}
