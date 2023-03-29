/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/26/2023
 */
package leetcode.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlidingWindowTest {

    /**
     *
     */
    @Test
    public void bestTimeForStockTxn() {
        BuyStock o = new BuyStock();

        int[] prices1 = {7,1,5,3,6,4};
        Assertions.assertEquals(5, o.maxProfit(prices1));

        int[] prices2 = {7,6,4,3,1};
        Assertions.assertEquals(0, o.maxProfit(prices2));
    }

    @Test
    public void longestStringTest() {
        LongestSubstring o = new LongestSubstring();

        String s1 = "abcde";
        String s2 = "abcabcdcdefg";
        Assertions.assertEquals(5, o.lengthOfLongestSubstring(s1));
        Assertions.assertEquals(5, o.lengthOfLongestSubstring(s2));

        Assertions.assertEquals(3, o.lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(1, o.lengthOfLongestSubstring("bbbbb"));
        Assertions.assertEquals(3, o.lengthOfLongestSubstring("pwwkew"));
    }
}
