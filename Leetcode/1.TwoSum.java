package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangfeidong
 *
 * 1.Two Sum: Use a hashmap to record number and index.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }
}
