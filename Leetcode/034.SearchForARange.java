package Leetcode;
/**
 * @author xiangfeidong
 *
 * 34.Search for a Range
 *
 * Binary serach for first index and last index.
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        //Look for first index of target.
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] == target) {
            res[0] = start;
        } else {
            //target is not in array.
            return res;
        }

        //Look for last index of target.
        start = 0;
        end = nums.length - 1;
        //Set "start+1<end" other than "start<end" as loop condition.
        //Because we let "start = mid" in loop, start will never be equal to end.
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        //Must first check end, because we are looking for last index.
        if (nums[end] == target) {
            res[1] = end;
        } else {
            res[1] = start;
        }

        return res;
    }
}
