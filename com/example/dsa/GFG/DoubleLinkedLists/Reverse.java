package com.example.dsa.GFG.DoubleLinkedLists;

public class Reverse {
    public static void main(String[] args) {
        Node head = new Node(0);

        head.next = new Node(1);
        head.next.prev = head;

        head.next.next = new Node(2);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;

        Node result = reverse(head);

        Traversal.loopTraverse(result);
    }

    public static Node reverse(Node head) {
        //  null <- 0 <-> 1 <-> 2 <-> 3 -> null

    
        return null;
    }
}
