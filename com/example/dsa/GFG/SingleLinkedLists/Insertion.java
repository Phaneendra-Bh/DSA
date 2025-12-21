package com.example.dsa.GFG.SingleLinkedLists;

public class Insertion {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        
        int data = -1;

        // Node result = insertAtBeginning(head, data);

        Node result = insertAtNthIndex(head, 3, data);

        Traversal.loopTraversal(result);
    }

    public static Node insertAtBeginning(Node head, int data) {
        Node temp = new Node(data);
        
        temp.next = head;

        return temp;
    }

    public static Node insertAtEnd(Node head, int data) {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = new Node(data);
        return head;
    }

    public static Node insertAtNthIndex_old(Node head, int n, int data) {
        if (n < 2) {
            Node dummy = new Node(data);
            dummy.next = head;
            return dummy;
        }
        
        int i=1;
        Node curr = head;
        Node prev = null;
        while (i < n && curr != null) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        Node dummy = new Node(data);
        prev.next = dummy;
        dummy.next = curr;

        return head;
    }

    public static Node insertAtNthIndex(Node head, int n, int data) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;

        for (int i=1; i<n; i++) {
            if (prev.next == null) {
                break;
            }
            prev = prev.next;
        }

        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;

        return dummy.next;
    }
}
