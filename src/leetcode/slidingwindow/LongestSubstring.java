/**
 * Course: NA but helpful for data structures...
 * Author: John DeMastri
 * Date: 3/29/2023
 */
package leetcode.slidingwindow;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring
 *  without repeating characters.
 */
public class LongestSubstring {

    /**
     * relatively simple - need to maintain the window to the current seq and max over time
     *
     * @param s - string to scan
     * @return - length of largest nonrepeating seq
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int curNewStart = 0;
        int curNewEnd = 0;

        for (char c : s.toCharArray()) {
            String curString = s.substring(curNewStart, curNewEnd);
            int firstRepeat = curString.indexOf(c);
            if (firstRepeat >= 0) {
                if (curNewEnd - curNewStart + 1 > maxLen) {
                    maxLen = curNewEnd - curNewStart;
                }
                curNewStart += firstRepeat+1;
            }
            curNewEnd++;
        }
        int finalLength = curNewEnd - curNewStart;
        if (finalLength > maxLen) {
            maxLen = finalLength;
        }
        return maxLen;
    }
}
