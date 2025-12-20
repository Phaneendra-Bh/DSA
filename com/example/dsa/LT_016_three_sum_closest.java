package com.example.dsa;

import java.util.Arrays;

/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 
Constraints:
3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
*/

public class LT_016_three_sum_closest {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        int target = 1;

        int result = threeSumClosest(nums, target);
        System.out.println(result);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int minSum = Integer.MAX_VALUE;
        int result = 0;
        int start, end;
        
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            int requiredSum = target-nums[i];
            
            start = i+1;
            end = nums.length-1;
            while (start < end) {
                if (Math.abs(requiredSum - nums[start] - nums[end]) < minSum) {
                    minSum = Math.abs(requiredSum - nums[start] - nums[end]);
                    result = nums[i] + nums[start] + nums[end];
                }
                
                if (requiredSum > nums[start] + nums[end]) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return result;
    }
}
