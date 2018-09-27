package Leetcode;
/**
 * @author xiangfeidong
 *
 * 33.Search in Rotated Sorted Array My Submissions Question
 *
 *                o  |                                  o
 *              o    |                                o
 *            o      |                             o
 *         o         |                           o
 *         --------------------                o
 *     start         |        o end          o
 *                   |      o              o
 *                   |   o              o
 *                   | o              o
 *     The mid can be in (left) or (right) of rotating line.
 *     Deal with 2 cases separately.
 *     Left can be represented by (num[mid] >= num[start]), which can still be used.
 */
public class No033SearchInRotatedSortedArrayMySubmissions {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
