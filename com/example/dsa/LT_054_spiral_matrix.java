package com.example.dsa;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

public class LT_054_spiral_matrix {
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};

        //int[][] matrix = {{1,2},{3,4}};
        // int[][] matrix = {{1}};

        List<Integer> results = spiralOrder(matrix);

        for (int i: results) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<Integer>();
	
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return results;
        }
	
	    recusrion(matrix, 0, matrix.length-1, 0, matrix[0].length-1, results);
	
	    return results;
    }

    public static void recusrion(int[][] matrix, int startRow, int endRow, int startColumn, int endColumn, List<Integer> results) {
        if (startRow > endRow || startColumn > endColumn) {
            return;
        }
        
        for (int j=startColumn; j<=endColumn; j++) {
            results.add(matrix[startRow][j]);
        }
        
        for (int i=startRow+1; i<=endRow; i++) {
            results.add(matrix[i][endColumn]);
        }
        
        if (startRow < endRow) {
            for (int j=endColumn-1; j>=startColumn; j--) {
                results.add(matrix[endRow][j]);
            }
        }
        
        if (startColumn < endColumn) {
            for (int i=endRow-1; i>startRow; i--) {
                results.add(matrix[i][startColumn]);
            }
        }
    
	    recusrion(matrix, 
            startRow+1, endRow-1, 
            startColumn+1, endColumn-1, 
            results);
    }
}
