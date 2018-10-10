package Leetcode;

/**
 * 209. Minimum Size Subarray Sum
 *
 * Two pointers.
 */
public class No209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s <= 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0, sum = nums[0];
        while (p1 < nums.length && p2 < nums.length) {
            while (sum < s && p2 < nums.length - 1) {
                sum += nums[++p2];
            }
            if (sum >= s) {
                res = Math.min(res, p2 - p1 + 1);
                sum -= nums[p1++];
            } else {
                break;
            }
        }

        if (res == Integer.MAX_VALUE) {
            return 0;
        } else {
            return res;
        }
    }
}
