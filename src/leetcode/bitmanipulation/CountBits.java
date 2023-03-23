package leetcode.bitmanipulation;

public class CountBits {
    // 0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1
    // 2,  4,6,  8,10,12,14,  16,18,20,22,24,26,28,30,  32
    // 1,  1,2,  1, 2, 2, 3,   1, 2, 2, 3, 2, 3, 3, 4,   1
    // 32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62
    //  1  2  2  3  2  3  3  4, 2, 3, 3, 4, 3, 4, 4, 5

    // if power of 2, 1
    // odd adds one to last count
    // even if power of 2, 1, else add count of remainder from highest power of 2 to total

    public int[] countBits(int n) {
        int[] outAns = new int[n+1];
        outAns[0] = 0;
        int nextPwrOf2 = 2;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1)
                outAns[i] = outAns[i - 1] + 1;
            else {
                if (i == nextPwrOf2) {
                    outAns[i] = 1;
                    nextPwrOf2 *= 2;
                } else {
                    outAns[i] = 1 /*outAns[lastPwrOf2]*/ + outAns[i - nextPwrOf2/2];
                }
            }
        }
        return outAns;
    }
}
