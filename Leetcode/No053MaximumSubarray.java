package Leetcode;
/**
 * @author xiangfeidong
 *
 * 53.Maximum Subarray
 *
 * sum[i~j] = sum[j]-sum[i-1]
 * We can traverse the array, record current sum and min sum so far.
 * The max (current sum - min sum) is answer.
 */
public class No053MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0, minSum = 0;
        for (int num : nums) {
            sum += num;
            res = Math.max(res, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return res;
    }
}
