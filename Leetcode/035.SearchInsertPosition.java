package Leetcode;
/**
 * @author xiangfeidong
 *
 * 35.Search Insert Position
 *
 * find first position of >= target.
 * !!Must consider if the insert position exceeds the range of array.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (nums[start] >= target) {
            return start;
        }
        return nums.length;
    }
}
