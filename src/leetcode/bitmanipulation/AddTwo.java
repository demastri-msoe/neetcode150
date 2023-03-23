package leetcode.bitmanipulation;

public class AddTwo {

    // the sum is the xor of the two numbers and a carry mask
    // the initial carry mask is the and of the two numbers shifted 1
    // need to add to this mask the or of the two numbers and the initial carry mask, again shifted 1

    public int getSum(int a, int b) {
        int carry1 = (a & b) << 1;
        boolean changed = false;

        do {
            int carry2 = ((a|b) & carry1) << 1;
            int outCarry = carry1 | carry2;
            changed = (outCarry != carry1);
            carry1 = outCarry;
        } while(changed);

        int outVal = a ^ b ^ carry1;

        return outVal;
    }
}
