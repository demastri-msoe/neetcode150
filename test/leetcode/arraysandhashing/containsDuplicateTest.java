package leetcode.arraysandhashing;

import leetcode.arraysandhashinng.containsDuplicate;
import leetcode.arraysandhashinng.topkfrequentelements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class containsDuplicateTest {
    containsDuplicate obj;
    topkfrequentelements topk;

    @BeforeAll
    void initilize() {
        obj = new containsDuplicate();
        topk = new topkfrequentelements();
    }

    @Test
    void hasNoElements() {
        boolean ok = obj.containsDuplicate(new int[]{});
        Assertions.assertFalse(ok);
    }

    @Test
    void hasNoMatchedElements() {
        boolean ok = obj.containsDuplicate(new int[]{1, 2, 3, 5, 6});
        Assertions.assertFalse(ok);
    }

    @Test
    void hasSomeMatchedElements() {
        boolean ok = obj.containsDuplicate(new int[]{1, 2, 3, 6, 2});
        Assertions.assertTrue(ok);
    }

    @Test
    void testTopK() {
        int[] outVal = topk.topKFrequent(new int[]{1, 1, 1, 2, 2, 3},2 );
        Assertions.assertEquals(2, outVal.length);
        Assertions.assertEquals(1, outVal[0]);
        Assertions.assertEquals(2, outVal[1]);

        outVal = topk.topKFrequent(new int[]{-1, -1},1 );
        Assertions.assertEquals(1, outVal.length);
        Assertions.assertEquals(-1, outVal[0]);

        outVal = topk.topKFrequent(new int[]{1, 2},2 );
        Assertions.assertEquals(2, outVal.length);
        Arrays.sort(outVal);
        Assertions.assertEquals( outVal[0], 1);
        Assertions.assertEquals( outVal[1], 2);

        outVal = topk.topKFrequent(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6},10 );
        Assertions.assertEquals(10, outVal.length);
        Arrays.sort(outVal);
        Assertions.assertEquals( outVal[0], 1);
        Assertions.assertEquals( outVal[1], 2);
        Assertions.assertEquals( outVal[2], 3);
        Assertions.assertEquals( outVal[3], 4);
        Assertions.assertEquals( outVal[4], 5);
        Assertions.assertEquals( outVal[5], 6);
        Assertions.assertEquals( outVal[6], 7);
        Assertions.assertEquals( outVal[7], 8);
        Assertions.assertEquals( outVal[8], 10);
        Assertions.assertEquals( outVal[9], 11);

    }

}
