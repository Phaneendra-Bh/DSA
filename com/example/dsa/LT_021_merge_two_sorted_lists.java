package com.example.dsa;

/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 
Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/

public class LT_021_merge_two_sorted_lists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(0);
        //l2.next = new ListNode(3);
        //l2.next.next = new ListNode(4);

        ListNode res = mergeTwoLists(null, l2);

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
	
	    ListNode merged = dummy;
	
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                merged.next = list1;
                list1 = list1.next;
                merged = merged.next;
            } else {
                merged.next = list2;
                list2 = list2.next;
                merged = merged.next;
            }
        }
	
        if (list1 != null) {
            merged.next = list1;
        }
        if (list2 != null) {
            merged.next = list2;
        }
	
	    return dummy.next;
    }
}
