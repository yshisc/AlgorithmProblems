package Leetcode;
/**
 * @author xiangfeidong
 *
 * 75.Sort Colors
 */
public class SortColors {
    public void sortColors(int[] nums) {
        //Sort 0 and non-0s.
        int i = 0, j = nums.length - 1;
        while (i < j) {
            //Find first number that is not 0 from left
            while (i < j && nums[i] == 0) {
                i++;
            }
            //Find first number that is 0 from right
            while (i < j && nums[j] != 0) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }

        //Sort 1 and 2. i has pointed to first number that is not 0.
        j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] == 1) {
                i++;
            }
            while (i < j && nums[j] == 2) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
