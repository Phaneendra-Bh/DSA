package com.example.dsa;

/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21
 
Constraints:
-2^31 <= x <= 2^31 - 1
*/

public class LT_007_reverse_integer {
    
    public static void main(String[] args) {
        int x = -200;
        int reverseInt = reverse(x);
        System.out.println(reverseInt);
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder();
	
        if (x < 0) {
            sb.append("-");
            x = -x;
        }
	
        while( x > 0) {
            sb.append(x % 10);
            x = x/10;
        }
	
        int result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch(NumberFormatException e) {
            // Do nothing
        }
	
	    return result;
    }
}
