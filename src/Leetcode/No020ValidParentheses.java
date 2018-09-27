package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * @author xiangfeidong
 *
 * 20.Valid Parentheses
 */
public class No020ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || map.get(c) != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
