---
title: Two Sum | LeetCode 1
date: 2016-09-07 08:40:12
tags: [Array, Hash Table]
categories: 算法题
---
# Question

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

Examples:

> Given nums = [2, 7, 11, 15], target = 9,

>Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

You may assume that each input would have exactly one solution.

# Solution
Traverse array and for each number, check if we have met target-number. We can use a hash table to record each number and its index. The time complexity is O(n).

# Code

## Java

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
		if (map.containsKey(target - nums[i])) {
			return new int[]{map.get(target - nums[i]), i};
        }

        map.put(nums[i], i);
    }
        
    return new int[]{-1, -1};
}
```

## Python

```python
def twoSum(self, nums, target):
	"""
	:type nums: List[int]
	:type target: int
	:rtype: List[int]
	"""
	dict = {}
	for i in range(len(nums)):
		if target-nums[i] in dict:
		return [dict[target-nums[i]], i]
		dict[nums[i]] = i
            
	return [-1, -1]
```
