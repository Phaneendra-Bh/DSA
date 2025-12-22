package com.example.dsa;

public class LT_024_swap_node_pairs {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode res = swapPairs(l1);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
	    dummy.next = head;
	
	    ListNode curr = dummy;
	
        while (curr.next != null && curr.next.next != null) {
            ListNode firstNode = curr.next;
            ListNode secondNode = firstNode.next;
            
            curr.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            
            curr = firstNode;
        }
	
	    return dummy.next;
    }
}
