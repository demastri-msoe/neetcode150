package leetcode.bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BitTests {
    @Test
    public void singleNumberTest() {
        SingleNumber o = new SingleNumber();

        int outVal = o.singleNumber(new int[] {2,2,1});
        Assertions.assertEquals(1, outVal);

        outVal = o.singleNumber(new int[] {4,1,2,1,2});
        Assertions.assertEquals(4, outVal);

        outVal = o.singleNumber(new int[] {1});
        Assertions.assertEquals(1, outVal);
    }

    @Test
    public void hammingWeightTest() {
        HammingWeight o = new HammingWeight();

        int outVal = o.hammingWeight(11);
        Assertions.assertEquals(3, outVal);

        outVal = o.hammingWeight(128);
        Assertions.assertEquals(1, outVal);

        outVal = o.hammingWeight(-3);
        Assertions.assertEquals(31, outVal);
    }

    @Test
    public void bitCount() {
        CountBits o = new CountBits();
        int [] outVal = o.countBits(8);

        Assertions.assertEquals(9, outVal.length);
        Assertions.assertEquals(0, outVal[0]);
        Assertions.assertEquals(1, outVal[1]);
        Assertions.assertEquals(1, outVal[2]);
        Assertions.assertEquals(2, outVal[3]);
        Assertions.assertEquals(1, outVal[4]);
        Assertions.assertEquals(2, outVal[5]);
        Assertions.assertEquals(2, outVal[6]);
        Assertions.assertEquals(3, outVal[7]);
        Assertions.assertEquals(1, outVal[8]);

        outVal = o.countBits(16);

        Assertions.assertEquals(17, outVal.length);
        Assertions.assertEquals(0, outVal[0]);
        Assertions.assertEquals(1, outVal[1]);
        Assertions.assertEquals(1, outVal[2]);
        Assertions.assertEquals(2, outVal[3]);
        Assertions.assertEquals(1, outVal[4]);
        Assertions.assertEquals(2, outVal[5]);
        Assertions.assertEquals(2, outVal[6]);
        Assertions.assertEquals(3, outVal[7]);
        Assertions.assertEquals(1, outVal[8]);
        Assertions.assertEquals(2, outVal[9]);
        Assertions.assertEquals(2, outVal[10]);
        Assertions.assertEquals(3, outVal[11]);
        Assertions.assertEquals(2, outVal[12]);
        Assertions.assertEquals(3, outVal[13]);
        Assertions.assertEquals(3, outVal[14]);
        Assertions.assertEquals(4, outVal[15]);
        Assertions.assertEquals(1, outVal[16]);
    }

    @Test
    void reverseBitsTest() {
        ReverseBits obj = new ReverseBits();
        int outVal = obj.reverseBits(43261596);
        Assertions.assertEquals(964176192, outVal);

        outVal = obj.reverseBits(-3);
        Assertions.assertEquals(-1073741825, outVal);
    }

    @Test
    void missingTest() {
        MissingNumber obj = new MissingNumber();
        int outVal = obj.missingNumber(new int[] {3, 0, 1});
        Assertions.assertEquals(2, outVal);

        outVal = obj.missingNumber(new int[] {0, 1});
        Assertions.assertEquals(2, outVal);

        outVal = obj.missingNumber(new int[] {9,6,4,2,3,5,7,0,1});
        Assertions.assertEquals(8, outVal);
    }
    @Test
    void addTwoTest() {
        AddTwo obj = new AddTwo();
        // 0011 + 1011
        int outVal = obj.getSum(3,11);
        Assertions.assertEquals(14, outVal);

        // 1 1110 1010 + 1 1010 1100 = 1ea + 1ac = 256+224+10, 256+160+12 = 490 + 428 = 918
        // bit 1-3 no carry
        // bit 4 carry no bit
        // bit 5 in carry no out carry
        // bit 6 in carry no out carry no bit
        // bit 7 in carry no out carry bit
        // bit 8 set up but 9, out carry no bit
        // bit 9 out carry with bit
        outVal = obj.getSum(490,428);
        Assertions.assertEquals(918, outVal);

        outVal = obj.getSum(1123,-7);
        Assertions.assertEquals(1116, outVal);

        outVal = obj.getSum(149,-3000);
        Assertions.assertEquals(-2851, outVal);
        outVal = obj.getSum(-3,-3000);
        Assertions.assertEquals(-3003, outVal);
    }

    @Test
    void reverseIntTest() {
        ReverseInteger obj = new ReverseInteger();
        // 0011 + 1011
        int outVal = obj.reverse(123);
        Assertions.assertEquals(321, outVal);

        outVal = obj.reverse(-123);
        Assertions.assertEquals(-321, outVal);

        outVal = obj.reverse(120);
        Assertions.assertEquals(21, outVal);

        outVal = obj.reverse(1534236469);
        Assertions.assertEquals(0, outVal);

        outVal = obj.reverse(1563847412);
        Assertions.assertEquals(0, outVal);
    }
}
