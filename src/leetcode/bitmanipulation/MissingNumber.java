package leetcode.bitmanipulation;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = nums.length*(nums.length+1)/2;
        for( int i: nums)
            sum -= i;
        return sum;
    }
}
