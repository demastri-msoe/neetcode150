package leetcode.arraysandhashing;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int sLen;
        if ((sLen = s.length()) != t.length())
            return false;
        int[] ltrCountS = new int[26];
        int[] ltrCountT = new int[26];
        for (int i = 0; i < sLen; i++) {
            ltrCountS[s.charAt(i) - 'a']++;
            ltrCountT[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(ltrCountS, ltrCountT);
    }
}
