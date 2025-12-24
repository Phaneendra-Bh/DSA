package com.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT_051_n_queens {
    public static void main(String[] args) {
        int n=4;
        
        solveNQueens(n);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        if (n == 2 || n == 3) {
            return result;
        } else if (n == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add("Q");
            result.add(list);
            return result;
        }

        String[][] board = new String[n][n];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = ".";
            }
        }

        List<List<String>> results = new ArrayList<>();
        
        boolean response = backtrack(results, board, n, 0);

        System.out.println("Response: " + response);

        for (int i=0;i<n;i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        
        return result;
    }

    public static boolean backtrack(List<List<String>> results, String[][] board, int n, int curr) {
        if (curr == n) {
            // add results
            return true;
        }
        
        for (int i=0; i<n; i++) {
            while (i<n) {
                if (isValidMove(board, i, curr)) {
                    board[curr][i] = "Q";
                }
                i++;
            }
            
            boolean res = backtrack(results, board, n, curr+1);
            if (res == false) {
                board[curr][i] = ".";
            } else {
                return true;
            }
        }
        
        return false;
    }

    public static boolean isValidMove(String[][] board, int nextRow, int nextColumn) {
        for (int i=0; i<board.length; i++) {
            if (board[nextRow][i] == "Q") {
                return false;
            }
            if (board[i][nextColumn] == "Q") {
                return false;
            }
        }
	
        for (int i = nextRow-1, j = nextColumn-1; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == "Q") {
                return false;
            }
        }
        
        for (int i = nextRow+1, j = nextColumn+1; i < board.length && j < board.length; i++,j++) {
            if (board[i][j] == "Q") {
                return false;
            }
        }
	
        for (int i = nextRow+1, j = nextColumn-1; i < board.length && j >= 0; i++,j--) {
            if (board[i][j] == "Q") {
                return false;
            }
        }
        
        for (int i = nextRow-1, j = nextColumn+1; i >= 0 && j < board.length; i--,j++) {
            if (board[i][j] == "Q") {
                return false;
            }
        }

        return true;
    }
}
