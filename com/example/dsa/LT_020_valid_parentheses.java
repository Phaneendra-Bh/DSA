package com.example.dsa;

import java.util.Stack;

public class LT_020_valid_parentheses {
    public static void main(String[] args) {
        String input = "[(){}]([)";
        boolean output = isValid(input);

        System.out.println(output);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
	
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
	
        return stack.isEmpty();
    }
}
