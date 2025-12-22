package com.example.dsa;

import java.util.Arrays;

public class LT_026_remove_duplicates_from_sorted_array {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};

        int res = removeDuplicates(nums);

        System.out.println("Result: " + res);

        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
	
        if (len < 2) {
            return len;
        }
        
        int prev = nums[0];
        int result = 1;
        
        int nextPos = 1;
        
        for (int i=1; i<len; i++) {
            if(nums[i] == prev) {
                continue;
            }
            
            nums[nextPos] = nums[i];
            prev = nums[i];
            result++;
            nextPos++;
        }
        
        return result;
    }
}
