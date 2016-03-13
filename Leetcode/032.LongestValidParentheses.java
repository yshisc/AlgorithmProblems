package Leetcode;

import java.util.Stack;
/**
 * @author xiangfeidong
 *
 * 32.Longest Valid Parentheses
 *
 * Solution 1: O(n) with stack
 * Traverse each character of input.
 * If current character is '(', push its index to the stack.
 * If current character is ')' and the character at the index of the peek of stack is '(',
 *   they are a matching pair so pop from the stack. Otherwise, we push the index of ')' to the stack.
 * After traversal, the stack will only contain the indices of characters which cannot be matched.
 * So substring between adjacent indices should be valid parentheses.
 * If the stack is empty, the whole input string is valid.
 *
 * Solution 2: O(n) with DP
 * State: f[i] denotes longest substring ended with s[i-1] that is valid.
 * Function: if s[i-1]=='(', f[i]=0.
 *           if s[i-1]==')', s[i-2] may be '(' or ')'.
 *               if s[i-2]='(', s[i-1] and s[i-2] is a matching pair.
 *               if s[i-2]=')', we know the longest valid substring ended with s[i-2] is f[i-1].
 *                 If there is a matching with s[i-1], the position should be i-1-f[i-1]-1 = i-f[i-1]-2
 *                 So if s[i-f[i-1]-2] is '(', is is a matching with s[i-1].
 *                 Then f[i] = length of substring [s[i-f[i-1]-2],s[i-1]] + largest valid substring ended with s[i-f[i-1]-3]
 *                           = f[i-1]+2 + s[i-f[i-1]-2]
 */
public class LongestValidParentheses {
    public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            if (c == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        if (stack.isEmpty()) {
            return s.length();
        }

        int maxLen = 0;
        int start = 0, end = s.length();
        while (!stack.isEmpty()) {
            start = stack.pop();
            maxLen = Math.max(maxLen, end - start - 1);
            end = start;
        }
        maxLen = Math.max(maxLen, end);

        return maxLen;
    }

    public int longestValidParentheses2(String s) {
        int[] f = new int[s.length() + 1];

        int maxLen = 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '(') {
                continue;
            }

            if (s.charAt(i - 2) == '(') {
                f[i] = f[i - 2] + 2;
            } else if (i - f[i - 1] - 2 >= 0 && s.charAt(i - f[i - 1] - 2) == '(') {
                f[i] = f[i - 1] + 2 + f[i - f[i - 1] - 2];
            }

            maxLen = Math.max(maxLen, f[i]);
        }

        return maxLen;
    }
}
