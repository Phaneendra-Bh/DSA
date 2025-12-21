package com.example.dsa.GFG.SingleLinkedLists;

public class Traversal {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
    
        loopTraversal(head);
        
        recursiveTraversal(head);
    }

    public static void loopTraversal(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println("");
    }
    
    public static void recursiveTraversal(Node head) {
        if (head == null) {
            System.out.println("");
            return;
        }

        System.out.print(head.data);
        if (head.next != null) {
            System.out.print(" -> ");
        }

        recursiveTraversal(head.next);
    }
}
