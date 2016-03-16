package Leetcode;
/**
 * @author xiangfeidong
 * 
 * 26.Remove Duplicates from Sorted Array
 *
 * Keep two pointers:
 * (1)p1 points to first position that has not been added to valid subarray, which is also the position ready to be assign as j's value.
 * (2)p2 moves to find first number that is not equal to (p1-2)'s number
 * Increment p1, and assign p2's number to p1's position, increment p2.
 * Finally p1 is the last position of new array.
 */
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int p1 = 2, p2 = 2;
        while (p2 < nums.length) {
            if (nums[p2] == nums[p1 - 2]) {
                p2++;
            } else {
                nums[p1++] = nums[p2++];
            }
        }

        return p1;
    }
}
