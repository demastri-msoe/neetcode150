/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/29/2023
 */
package leetcode.slidingwindow;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve
 * any profit, return 0.
 */
public class BuyStock {

    /**
     * My first attempt at this was a pitiful n^2 algorithm, then I remembered this approach
     * need to keep current low to check future profits.  Earlier profit may be higher so
     * you need to keep that around, even if generated with a "higher low"
     *
     * @param prices - values of ths stock
     * @return - max gap between low/high prices
     */
    public int maxProfit(int[] prices) {
        int curMax = 0;
        int curLow = prices[0];
        for (int s = 1; s < prices.length; s++) {
            if (prices[s] < curLow) {
                curLow = prices[s];
            }
            if (prices[s] - curLow > curMax) {
                curMax = prices[s] - curLow;
            }
        }
        return curMax;
    }
}
