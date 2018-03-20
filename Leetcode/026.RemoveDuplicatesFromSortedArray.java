package Leetcode;
/**
 * @author xiangfeidong
 *
 * 26.Remove Duplicates from Sorted Array
 *
 * Keep two pointers:
 * (1)p1 points to first place of numbers with same value
 * (2)p2 moves to find first number that is not equal to p1's number
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int p1 = 0, p2 = 1;
        while (p2 < nums.length) {
            if (nums[p1] == nums[p2]) {
                p2++;
            } else {
                nums[++p1] = nums[p2++];
            }
        }

        return p1 + 1;
    }
}
