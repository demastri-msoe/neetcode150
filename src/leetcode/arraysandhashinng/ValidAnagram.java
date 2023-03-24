package leetcode.arraysandhashinng;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int sLen;
        if ((sLen = s.length()) != t.length())
            return false;
        int[] ltrCountS = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] ltrCountT = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < sLen; i++) {
            ltrCountS[s.charAt(i) - 'a']++;
            ltrCountT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ltrCountS[i] != ltrCountT[i])
                return false;
        }
        return true;
    }
}
