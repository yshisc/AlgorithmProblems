package Leetcode;
/**
 * @author xiangfeidong
 *
 * 41.First Missing Positive
 *
 * Use the thinking of bucket sort, but do not use extra space.
 * Since we are looking for positive, we can store x in nums[x-1].
 * Go through the array, if a number x is in range of [1,n], swap it to x-1.
 */
public class No041FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            //Note that the number in x-1 may be equal to x, we should check it otherwise it will be a infinite loop.
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
