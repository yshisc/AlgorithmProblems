package Leetcode;
/**
 * @author xiangfeidong
 *
 * 42.Trapping Rain Water
 *
 * Solution 1:
 * Assume for index i, l = max height on left of i, r = max height on right of i.
 * Then if min(l,r)>height[i], it can hold water on i, the volumn is height[i]-min(l,r).
 * So we can traverse height array to get max height on both left and right of each bar,
 * and add up volumn on each bar.
 */
public class TrappingRainWater {
    //Improvement: 2nd and 3rd loop can combined to one loop.
    public static int trap(int[] height) {
        int n = height.length;

        //Loop 1: get max height on left  of each bar.
        int[] leftMax = new int[n];
        int maxHeight = 0;
        for (int i = 1; i < n; i++) {
            maxHeight = Math.max(maxHeight, height[i - 1]);
            leftMax[i] = maxHeight;
        }

        //Loop 1: get max height on right of each bar.
        int[] rightMax = new int[n];
        maxHeight = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxHeight = Math.max(maxHeight, height[i + 1]);
            rightMax[i] = maxHeight;
        }

        //Loop 3: add up volumn on each bar.
        int water = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < minHeight) {
                water += minHeight - height[i];
            }
        }

        return water;
    }

}
