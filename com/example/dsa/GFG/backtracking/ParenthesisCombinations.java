package com.example.dsa.GFG.backtracking;

public class ParenthesisCombinations {
    public static void main(String[] args) {
        int n=5;

        String paths = "";

        parenthesis(n, 0, 0, paths);
    }

    public static void parenthesis(int n, int open, int closed, String paths) {
        if (paths.length() == 2 * n) {
            System.out.println(paths);
            return;
        }

        if (open < n) {
            parenthesis(n, open + 1, closed, paths+"(");
        }

        if (closed < open) {
            parenthesis(n, open, closed + 1, paths+")");
        }
    }
}