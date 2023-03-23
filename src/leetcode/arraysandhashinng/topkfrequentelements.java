package leetcode.arraysandhashinng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class topkfrequentelements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occ = new HashMap<>();
        for (int x : nums) {
            occ.computeIfAbsent(x, z -> 0);
            occ.put(x, occ.get(x) + 1);
        }
        HashMap<Integer, List<Integer>> inv = new HashMap<>();
        for (int x : occ.keySet()) {
            inv.computeIfAbsent(occ.get(x), q -> new ArrayList<>());
            inv.get(occ.get(x)).add(x);
        }
        Object[] occSizes = inv.keySet().toArray();
        Arrays.sort(occSizes);

        int[] outArray = new int[k];
        int outCount = 0;
        for (int i = occSizes.length-1; i >= 0 && outCount < k; i--)
            for( int x: inv.get(occSizes[i])) {
                outArray[outCount++] = x;
            }
        return outArray;
    }
}
