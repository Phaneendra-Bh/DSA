package com.example.dsa;

/* 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 
Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

public class LT_002_add_two_numbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode res = addTwoNumbers(l1, l2);

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
		ListNode temp = result;
		
		int carry = 0;
		int workingSum = 0;
		while(l1 != null || l2 != null) {
			workingSum = carry;
			if (l1 != null) {
				workingSum = workingSum + l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				workingSum = workingSum + l2.val;
				l2 = l2.next;
			}
			
			temp.val = workingSum % 10;
			
			if (workingSum > 9) {
				carry = workingSum/10;
			} else {
				carry = 0;
			}
			
			if (l1 != null || l2 != null) {
				temp.next = new ListNode();
				temp = temp.next;
			}
		}
		
		if (carry > 0) {
			temp.next = new ListNode(carry);
		}
		
		return result;
    }
}
