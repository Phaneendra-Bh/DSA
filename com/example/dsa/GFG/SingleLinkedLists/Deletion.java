package com.example.dsa.GFG.SingleLinkedLists;

public class Deletion {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        //head.next.next = new Node(2);
        //head.next.next.next = new Node(3);

        // Node result = deletionAtBeginning(head);

        // Node result = deletionAtEnd(head);

        int pos = 1;
        Node result = deletionAtNthPosition(head, pos);

        Traversal.loopTraversal(result);
    }

    public static Node deletionAtBeginning(Node head) {
        if (head == null) {
            return null;
        }
       
        Node next = head.next;
        head.next = null;

        return next;
    }

    public static Node deletionAtEnd(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node curr = head;
        Node prev = null;
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;

        return head;
    }

    public static Node deletionAtNthPosition(Node head, int pos) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node curr = dummy;

        for (int i=1; i<pos; i++) {
            if (curr.next == null) {
                return dummy.next;
            }
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }

        return dummy.next;
    }
}
