package com.example.dsa;

import java.util.Arrays;

public class LT_027_remove_duplicates {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};

        int k = 2;

        int result = removeElement(nums, k);

        System.out.println("Result: " + result);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
	
        if (nums.length == 1) {
            if (nums[0] == val) return 0;
            if (nums[0] != val) return 1;
        }
	
        int start = 0;
        int end = nums.length - 1;
	
        int result = 0;
        while (start <= end) {
            if (nums[end] == val) {
                end--;
            } else if (nums[start] != val) {
                start++;
                result++;
            } else if (nums[start] == val) {
                nums[start] = nums[end];
                start++;
                end--;
                result++;
            }
        }

        return result;
    }
}
