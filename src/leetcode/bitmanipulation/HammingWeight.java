package leetcode.bitmanipulation;

public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int outCount=0;
        while(n!= 0) {
            if( (n & 0x00001) != 0)
                outCount++;
            n = n >>> 1;
        }
        return outCount;
    }
}
