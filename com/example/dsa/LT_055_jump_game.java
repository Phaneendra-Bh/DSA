package com.example.dsa;

public class LT_055_jump_game {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        boolean result = canJump(nums);

        System.out.println("Can jump is: " + result);
    }

    // Forward Greedy approach
    public static boolean canJump_greeedy(int[] nums) {
        int farthest = 0;

        for (int i=0; i<nums.length; i++) {
            if (i < farthest) {
                return false;
            }

            farthest = Math.max(farthest, i + nums[i]);

            if (farthest >= nums.length-1){
                return true;
            }
        }

        return true;
    }

    // Backward Greedy approach
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        
        int minRequiredCount = 1;

        for (int currentIndex = nums.length-2; currentIndex >=0; currentIndex--) {
            if (nums[currentIndex] < minRequiredCount) {
                minRequiredCount++;
            } else {
                minRequiredCount = 1;
            }
        }

        return minRequiredCount == 1;
    }

    public static boolean canJump_old(int[] nums) {
        return backtrack_old(nums, 0);
    }

    // exponential time
    public static boolean backtrack_old(int[] nums, int curr) {
        if (curr == nums.length - 1) {
            return true;
        }

        for (int i=1; i<=nums[curr]; i++) {
            if (backtrack_old(nums, curr + i)) {
                return true;
            }
        }

        return false;
    }
}
