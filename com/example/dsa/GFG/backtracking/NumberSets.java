package com.example.dsa.GFG.backtracking;

import java.util.ArrayList;

public class NumberSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        
        ArrayList<Integer> combinations = new ArrayList<>(); 
        
        generateAllCombinations(nums, 0, combinations);
    }

    public static void generateAllCombinations(int[] nums, int index, ArrayList<Integer> paths) {
        // base case
        if (index == nums.length) {
            System.out.println(paths);
            return;
        }

        paths.add(nums[index]);
        generateAllCombinations(nums, index+1, paths);

        paths.remove(paths.size()-1);
        generateAllCombinations(nums, index+1, paths);
    }
}
