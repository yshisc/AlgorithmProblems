package Leetcode;
/**
 * @author xiangfeidong
 * 
 * 45.Jump Game II
 */
public class No045JumpGame2 {
    /**
     * Solution 1: DP
     * state: f[i] denotes least steps to position i
     * function: f[i] = min{f[j]+1} where 0<=j<i && j+nums[j]>=i
     * intialize: f[0] = 0
     * answer: f[n-1]
     */
    public int jump(int[] nums) {
        int[] minSteps = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            minSteps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    minSteps[i] = Math.min(minSteps[i], minSteps[j] + 1);
                }
            }
        }
        return minSteps[nums.length - 1];
    }

    /**
     * Solution 2: Greedy
     * Traverse array and calculate the coverage interval of each jump.
     * When the interval reach last index, return the number of jumps.
     */
    public int jump2(int[] nums) {
        int jump = 0;
        //Intit coverage interval as [0,0]
        int start = 0, end = 0;
        while (end < nums.length - 1) {
            jump++;
            //Record farthest position this jump can reach.
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (i + nums[i] > farthest) {
                    farthest = i + nums[i];
                }
            }
            //Update start and end of coverage interval for next jump.
            start = end + 1;
            end = farthest;
        }
        return jump;
    }
}
