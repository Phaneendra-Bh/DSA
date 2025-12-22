package com.example.dsa;

import java.util.List;
import java.util.ArrayList;


public class LT_022_generate_parentheses {
    public static void main(String[] args) {
        int n = 0;

        List<String> list =  generateParentheses(n);

        for (String s: list) {
            System.out.println(s);
        }
    }

    public static List<String> generateParentheses(int n) {
        ArrayList<String> output = new ArrayList<String>();
        
        backtrack(n, 0, 0, "", output);

        return output;
    }

    public static void backtrack(int n, int open, int closed, String expr, List<String> output) {
        if (expr.length() == 2 * n) {
            output.add(expr);
            return;
        }

        if (open < n) {
            backtrack(n, open+1, closed, expr+"(", output);
        }

        if (closed < open) {
            backtrack(n, open, closed+1, expr+")", output);
        }
    }
    
}
