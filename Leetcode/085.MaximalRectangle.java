package Leetcode;

import java.util.Stack;

/**
 * @author xiangfeidong
 *
 * 85.Maximal Rectangle
 *
 * With the algorithm in 84.Largest Rectangle in Histogram, we are able to find max rectangle in 1D array in O(n) time.
 * In matrix that contains 0s and 1s, we can traverse from top to bottom.
 * Each row we can get an array that contains heights of histograms, so we can use 84 algorithm in it.
 *
 * O(mn) time
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return maxArea;
        }

        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

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
