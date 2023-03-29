/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/29/2023
 */
package leetcode.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BackTrackTest {

    @Test
    public void doSubsetTest() {
        Subsets o = new Subsets();

        List<List<Integer>> outLists = o.subsets(new int[] {1,2,3});
        Assertions.assertEquals(8, outLists.size());

        outLists = o.subsets(new int[] {1,2});
        Assertions.assertEquals(4, outLists.size());

        outLists = o.subsets(new int[] {0});
        Assertions.assertEquals(2, outLists.size());

        outLists = o.subsets(new int[] {1,2,3,4});
        Assertions.assertEquals(16, outLists.size());
    }
}
