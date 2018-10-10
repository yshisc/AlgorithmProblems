package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 287. Find the Duplicate Number
 */
public class No287FindTheDuplicateNumber {
    /**
     * Sort.
     */
    public int findDuplicate1(final int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * Hashset.
     */
    public int findDuplicate2(final int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (final int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }

    /**
     * Since every number in array is between 1~n, so it must point to index of another number. In such way the array
     * can be traversed infinitely. If we consider the array as a linked list, there must be a circle in the linked
     * list. So we can use slow and fast pointer to solve the problem.
     *
     * Note that two pointers must start at same position.
     */
    public int findDuplicate3(final int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
