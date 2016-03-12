package Leetcode;

import java.util.Arrays;

/**
 * @author xiangfeidong
 *
 * 16.3Sum Closest
 *
 * Sort array, enumerate first number, use two pointers to try combinations of second and third number.
 * Update result each iteration if current sum is closer to target.
 * If find a sum equal to target, directly return it.
 */
public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 0) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0, diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    start++;
                } else  {
                    end--;
                }
            }
        }

        return res;
    }
}
