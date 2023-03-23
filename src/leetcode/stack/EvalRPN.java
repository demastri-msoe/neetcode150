package leetcode.stack;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> exp = new Stack<>();
        for (String token : tokens) {
            if (token.length()==1 && "+-*/".indexOf(token.charAt(0)) >= 0) {
                int arg1 = exp.pop();
                int arg2 = exp.pop();
                switch (token) {
                    case "+":
                        exp.push( arg1+arg2);
                        break;
                    case "-":
                        exp.push( arg1-arg2);
                        break;
                    case "*":
                        exp.push( arg1*arg2);
                        break;
                    case "/":
                        exp.push( arg2/arg1);
                        break;
                }
            } else {
                exp.push(Integer.parseInt(token));
            }
        }
        return exp.pop();
    }
}
