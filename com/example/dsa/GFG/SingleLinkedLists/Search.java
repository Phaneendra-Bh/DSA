package com.example.dsa.GFG.SingleLinkedLists;

public class Search {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);

        int data = 0;

        boolean found = search(head, data);
        
        System.out.println(found);
    }

    public static boolean search(Node head, int data) {
        while(head != null) {
            if (head.data == data) {
                return true;
            }

            head = head.next;
        }

        return false;
    }
}

