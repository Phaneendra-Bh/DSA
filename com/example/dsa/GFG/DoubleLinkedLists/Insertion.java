package com.example.dsa.GFG.DoubleLinkedLists;

public class Insertion {
    public static void main(String[] args) {
        Node head = new Node(0);

        head.next = new Node(1);
        head.next.prev = head;

        head.next.next = new Node(2);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;

        int data = 100;

        int pos = 6;

        Node result = insertion(head, data, pos);

        Traversal.loopTraverse(result);
    }

    public static Node insertion(Node head, int data, int pos) {
        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node curr = dummy;

        for (int i=1; i<pos; i++) {
            if (curr.next == null) {
                return dummy.next;
            }
            curr = curr.next;
        }

        Node newNode = new Node(data);
        newNode.next = curr.next;
        newNode.prev = curr;

        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;

        Node newHead = dummy.next;
        newHead.prev = null;
        
        return newHead;
    }
}
