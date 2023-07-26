/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/30/2023
 */
package leetcode.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreedyTests {

    @Test
    public void jumpTest() {
        JumpGame o = new JumpGame();

        Assertions.assertTrue(o.canJump(new int[]{2, 3, 1, 1, 4}));
        Assertions.assertFalse(o.canJump(new int[]{3, 2, 1, 0, 4}));
        Assertions.assertTrue(o.canJump(new int[]{0}));
        Assertions.assertTrue(o.canJump(new int[]{2, 5, 0, 0}));
    }

}
