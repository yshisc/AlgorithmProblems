package Leetcode;

import java.util.Stack;

/**
 * @author xiangfeidong
 *
 * 84.Largest Rectangle in Histogram
 *
 * Maintain a stack
 * (1)If stack is empty or current value >= stack peek's value, push this into stack.
 * (2)Otherwise keep popping until current value >= stack peek's value.
 *
 * While popping calculate area
 * (1)if stack is empty, it means that just popped index's value is smallest, area = input[top] * i
 * (2)if stack is not empty then just popped index's value <= all values from stack peek + 1 to i-1. area = input[top] * (i - stack.peek() - 1);
 *
 * O(n) space, O(n) time.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        if (heights.length == 0) {
            return maxArea;
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    maxArea = Math.max(maxArea, heights[top] * i);
                } else {
                    maxArea = Math.max(maxArea, heights[top] * (i - stack.peek() - 1));
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                maxArea = Math.max(maxArea, heights[top] * i);
            } else {
                maxArea = Math.max(maxArea, heights[top] * (i - stack.peek() - 1));
            }
        }

        return maxArea;
    }
}
