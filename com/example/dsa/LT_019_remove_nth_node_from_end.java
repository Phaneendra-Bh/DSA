package com.example.dsa;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LT_019_remove_nth_node_from_end {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);

        int n = 1;
        
        ListNode res = removeNthFromEnd(head, n);
        
        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fp = dummy;
        ListNode sp = dummy;
        
        for(int i=0; i<=n; i++) {
            fp = fp.next;
        }
        
        while(fp != null) {
            fp = fp.next;
            sp = sp.next;
        }
        
        sp.next = sp.next.next;
        
        return dummy.next;
    }
}
