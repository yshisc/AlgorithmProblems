package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author xiangfeidong
 *
 * 18. 4Sum: Sort array, enumerate first and second number, and use two pointers to find combinations of third and fourth numbers.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
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

            for (int j = i + 1; j < nums.length; j++) {
                //Avoid duplicates of second number.
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int start = j + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[start], nums[end])));

                        start++;
                        //Avoid duplicates of third number.
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }

                        end--;
                        //Avoid duplicates of fourth number.
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (sum < target) {
                        start++;
                    } else  {
                        end--;
                    }
                }
            }
        }

        return res;
    }
}
