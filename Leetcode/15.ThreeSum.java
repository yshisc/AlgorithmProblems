package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 15.3Sum: Sort array, enumerate first number, and use two pointers to find combinations of second and third numbers.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //Avoid duplicates of first number.
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));

                    start++;
                    //Avoid duplicates of second number.
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }

                    end--;
                    //Avoid duplicates of third number.
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < 0) {
                    start++;
                } else  {
                    end--;
                }
            }
        }

        return res;
    }
}
