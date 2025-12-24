package com.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Example 3:
Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 
Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/

public class LT_056_merge_intervals {
    public static void main(String[] args) {
        int[][] intervals = {{4,7}, {1,4}};

        int[][] result = merge(intervals);

        for (int i=0; i<result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
		    return new int[0][0];
	    }
        if (intervals.length == 1) {
            return intervals;
        }
	
        Arrays.sort(intervals,
            (a,b) -> Integer.compare(a[0], b[0])
        );

	    ArrayList<int[]> list = new ArrayList<>();

        int startInterval = intervals[0][0];
        int endInterval = intervals[0][1];
	
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] <= endInterval) {
                if(intervals[i][1] > endInterval) {
                    endInterval = intervals[i][1];
                }
            } else {
                list.add(new int[]{startInterval, endInterval});
                startInterval = intervals[i][0];
                endInterval = intervals[i][1];
            }
        }
        list.add(new int[]{startInterval, endInterval});

        return list.toArray(new int[list.size()][]);
    }
}
