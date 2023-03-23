package leetcode.stack;

import java.util.Stack;

public class ValidParens {
    public boolean isValid(String s) {
        Stack<Character> curOpen = new Stack<>();

        for(Character c: s.toCharArray()) {
            if( "({[".indexOf(c) >= 0 )
                curOpen.push(c);
            else if( curOpen.size() > 0 && ((c == ')' && curOpen.peek() == '(') ||
                    (c == '}' && curOpen.peek() == '{') ||
                    (c == ']' && curOpen.peek() == '[')) )
                curOpen.pop();
            else
                return false;
        }
        return curOpen.size() == 0;
    }
}
