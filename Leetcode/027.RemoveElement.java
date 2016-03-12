package Leetcode;
/**
 * @author xiangfeidong
 *
 * 27.Remove Element
 *
 * Keep Two pointers: p1 start from left, p2 start from right.
 *      If the number equal to target, assign p2's number to it, and move p2.
 *      If the number not equal to target, move p1.
 * keep doing until start > end.
 * When p1 == p2: (1)if nums[p1]==target, we will decrement p2. So p2 is the last position of new array.
 *                (2)if nums[p1]!=target, we will not move p2. So p2 is still last position of new array.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] == val) {
                nums[p1] = nums[p2--];
            } else {
                p1++;
            }
        }

        return p2 + 1;
    }
}
