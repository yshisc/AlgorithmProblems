package Leetcode;
/**
 * @author xiangfeidong
 *
 * 31. Next Permutation
 *
 * Find a position i, such that (nums[i+1],nums[i+2],...,nums[n-1]) is descending and (nums[i],nums[i+1],...,nums[n-1]) is not descending.
 * So we cannot make (nums[i+1],nums[i+2],...,nums[n-1]) larger by reorder it.
 * Then, in (nums[i+1],nums[i+2],...,nums[n-1]), we find the least number that is larger than nums[i], and swap them.
 * Finally, reverse (nums[i+1],nums[i+2],...,nums[n-1]).
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                //Find a position i, such that (nums[i+1],nums[i+2],...,nums[n-1]) is descending
                //and (nums[i],nums[i+1],...,nums[n-1]) is not descending.
                for (int j = nums.length - 1; j > i; j--) {
                    //we find the least number that is larger than nums[i]
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }

        //The whole array is sorted descending, reverse it.
        reverse(nums, 0, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
