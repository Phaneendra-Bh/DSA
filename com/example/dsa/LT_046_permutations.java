package com.example.dsa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LT_046_permutations {
    public static void main(String[] args) {
        int[] nums = {0,-1,1};

        List<List<Integer>> result = permute(nums);

        for(List<Integer> r: result) {
            for (int i: r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
	
        boolean[] usedIntegers = new boolean[nums.length];
        
	    backtrack(nums, results, new ArrayList<>(), usedIntegers);

        return results;
    }

    public static void backtrack(int[] nums, List<List<Integer>> results, List<Integer> permutation, boolean[] used) {
        // base condition
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (used[i]) continue; 
            
            // choose
            permutation.add(nums[i]);
            used[i] = true;
            
            // explore
            backtrack(nums, results, permutation, used);
            
            // backtrace
            used[i] = false;
            permutation.remove(permutation.size()-1);
        }
    }
}
