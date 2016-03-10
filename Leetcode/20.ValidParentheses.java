package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.print(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Queue<Character> queue = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                System.out.println("queue in:" + c);
                queue.offer(c);
            } else {
                System.out.print("queue out:" + c);
                System.out.println("  compare " + c + " with " + queue.peek());
                if (map.get(c) != queue.poll()) {
                    return false;
                }
            }
        }

        return queue.isEmpty();
    }
}
