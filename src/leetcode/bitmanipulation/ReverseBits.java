package leetcode.bitmanipulation;

public class ReverseBits {
    // 1 -> 10000000000000000000000000000000000

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int outVal = 0;
        for( int i=0; i<32; i++)
            outVal += (((1<<i) & n) == 0 ? 0 : (1 << 31-i));
        return outVal;
    }
}
