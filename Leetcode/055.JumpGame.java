package Leetcode;
/**
 * @author xiangfeidong
 *
 * 55.Jump Game
 */
public class JumpGame {
    /**
     * Solution 1: Greedy
     * Imagine nums[i] represents an interval which starts at i and length is nums[i],
     *   our task is to check if after merging all the intervals, whether it can reach end of array.
     * Maintain a variable to record farthest position we can reach, traverse array to update the variable,
     *   finally compare it with array's last index.
     */
    public boolean canJump1(int[] nums) {
        int farthest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= farthest && i + nums[i] > farthest) {
                farthest = i + nums[i];
            }
        }
        return farthest >= nums.length - 1;
    }

    /**
     * Solution 2: DP
     * state: f[i] denotes we can reach index i
     * function: f[i]=true if exists 0<=j<i s.t. f[j]=true && j+nums[j]>=i
     * initialize: f[0]=true
     * answer: f[n-1]
     */
    public boolean canJump2(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (canReach[j] && j + nums[j] >= i) {
                    canReach[i] = true;
                    break;
                }
            }
        }
        return canReach[nums.length - 1];
    }
}
