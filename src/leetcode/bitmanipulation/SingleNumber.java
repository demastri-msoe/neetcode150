package leetcode.bitmanipulation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int out = 0;
        for( int i:nums)
            out = out ^ i;
        return out;
    }
}
