package Leetcode;
/**
 * @author xiangfeidong
 *
 * 11.Container With Most Water
 *
 * Keep two pointers: i and j.
 * Each iteration:
 *    calculate area, and update max area if current area is larger.
 *    if height[i] > height[j], then areas formed by [i+1,j],[i+2,j],... will be less than current area. So we decrement j.
 *    else, increment i.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int curArea = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, curArea);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }
}
