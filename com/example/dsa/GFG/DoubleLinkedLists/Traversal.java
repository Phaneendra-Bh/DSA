package com.example.dsa.GFG.DoubleLinkedLists;

public class Traversal {
    public static void main(String[] args) {
        Node head = new Node(0);

        head.next = new Node(1);
        head.next.prev = head;

        head.next.next = new Node(2);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;

        // loopTraverse(head);

        // recursiveTraversal(head);

        // loopTraversalFromTail(head.next.next.next);

        recursiveTraversalFromTail(head.next.next.next);
    }

    public static void loopTraverse(Node head) {
        while(head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" <-> ");
            }

            head = head.next;
        }
        System.out.println("");
    }

    public static void recursiveTraversal(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }

        System.out.print(head.data);
        if (head.next != null) {
            System.out.print(" <-> ");
        }

        recursiveTraversal(head.next);
    }

    public static void loopTraversalFromTail(Node tail) {
        while (tail != null) {
            System.out.print(tail.data);
            if (tail.prev != null) {
                System.out.print(" <-> ");
            }
            tail = tail.prev;
        }
    }

    public static void recursiveTraversalFromTail(Node tail) {
        if (tail == null) {
            return;
        }

        System.out.print(tail.data);
        if (tail.prev != null) {
            System.out.print(" <-> ");
        }

        recursiveTraversalFromTail(tail.prev);
    }
}
