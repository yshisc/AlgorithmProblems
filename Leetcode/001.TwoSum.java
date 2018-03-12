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
        final Map<Integer, Integer> numberIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberIndices.containsKey(target - nums[i])) {
                return new int[]{numberIndices.get(target - nums[i]), i};
            }
            
            numberIndices.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }
}
