package Leetcode;
/**
 * @author xiangfeidong
 *
 * 70.Climbing Stairs
 *
 * Function: f[i] = f[i-1]+f[i-2] We can climb to i in one step from either i-1 or i-2.
 */
public class No070ClimbingStairs {
    //Solution 1
    public int climbStairs1(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;

        for (int i = 2; i < n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n - 1];
    }

    //Use two variables instead of using an array
    public int climbStairs2(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int oneStepBefore = 2, twoStepsBefore = 1;
        for (int i = 3; i <= n; i++) {
            int temp = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = temp;
        }

        return oneStepBefore;
    }
}
