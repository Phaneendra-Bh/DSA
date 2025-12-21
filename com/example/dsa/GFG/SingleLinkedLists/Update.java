package com.example.dsa.GFG.SingleLinkedLists;

public class Update {
    public static void main(String[] args) {
        Node head = new Node(0);
        //head.next = new Node(1);
        //head.next.next = new Node(2);

        int pos = 1;

        int data = 100;

        Node result = update(head, data, pos);

        Traversal.loopTraversal(result);
    }

    public static Node update(Node head, int data, int pos) {
        Node curr = head;
        for (int n=1; curr != null; n++) {
            if (n == pos) {
                curr.data = data;
                break;
            }
            curr = curr.next;
        }

        return head;
    }
}
