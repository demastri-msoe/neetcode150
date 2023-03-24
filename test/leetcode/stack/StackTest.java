package leetcode.stack;

import leetcode.bitmanipulation.SingleNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StackTest {

    @Test
    public void parensTest() {
        ValidParens o = new ValidParens();

        Assertions.assertTrue(o.isValid("()"));
        Assertions.assertTrue(o.isValid("()[]{}"));
        Assertions.assertFalse(o.isValid("(]"));

    }

    @Test
    public void minStackTest() {
        Integer[] outVals = minStackDriver(
                new String[] {"MinStack","push","push","push","getMin","pop","top","getMin"},
                new Integer[] {null, -2, 0, -3, null, null, null, null}
        );
        Assertions.assertNull(outVals[0]);
        Assertions.assertNull(outVals[1]);
        Assertions.assertNull(outVals[2]);
        Assertions.assertNull(outVals[3]);
        Assertions.assertEquals(-3, outVals[4]);
        Assertions.assertNull(outVals[5]);
        Assertions.assertEquals(-0, outVals[6]);
        Assertions.assertEquals(-2, outVals[7]);
    }

    public Integer[] minStackDriver( String[] cmds, Integer[] values) {
        MinStack s = null;
        Integer [] outVals = new Integer[cmds.length];
        for(int i=0; i<cmds.length; i++ ) {
            switch( cmds[i]) {
                case"MinStack":
                    s = new MinStack();
                    outVals[i] = null;
                    break;
                case"push":
                    s.push(values[i]);
                    outVals[i] = null;
                    break;
                case"pop":
                    s.pop();
                    outVals[i] = null;
                    break;
                case"top":
                    outVals[i] = s.top();
                    break;
                case"getMin":
                    outVals[i] = s.getMin();
                    break;
            }
        }
        return outVals;
    }

    @Test
    public void rpnTest() {
        EvalRPN obj = new EvalRPN();

        int outVal = obj.evalRPN(new String[]{"2","1","+","3","*"});
        Assertions.assertEquals(9, outVal);

        outVal = obj.evalRPN(new String[]{"4","13","5","/","+"});
        Assertions.assertEquals(6, outVal);

        outVal = obj.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        Assertions.assertEquals(22, outVal);

        outVal = obj.evalRPN(new String[]{"10","6","-"});
        Assertions.assertEquals(4, outVal);
    }
}
