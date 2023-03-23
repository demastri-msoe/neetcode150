package leetcode.bitmanipulation;

public class ReverseInteger {
    public int reverse(int x) {
        int cap = (int)(Math.pow(2,32)/10);
        boolean isNeg = (x<0);
        x *= (isNeg?-1:1);
        int outVal = 0;
        while( x>0 ) {
            if(outVal > cap) // would underflow
                return 0;
            int thisDigit = x%10;
            int possVal = 10*outVal+thisDigit;
            if(possVal < outVal ) // did underflow
                return 0;
            outVal = possVal;
            x /= 10;
        }
        outVal *= (isNeg ? -1 : 1);
        return outVal;
    }
}
