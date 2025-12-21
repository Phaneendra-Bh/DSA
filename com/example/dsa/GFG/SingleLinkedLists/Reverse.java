package com.example.dsa.GFG.SingleLinkedLists;

import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        //head.next.next = new Node(2);
        //head.next.next.next = new Node(3);

        // Node result = reverse(head);

        // Node result = reverseThroughRecursion(head);

        Node result = reverseThroughStack(head);

        Traversal.loopTraversal(result);
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node curr = head;
        Node prev = null;

        while(curr != null) {
            Node temp = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static Node reverseThroughRecursion(Node head) {
        if (head.next == null) {
            return head;
        }

        Node newNode = reverseThroughRecursion(head.next);

        head.next.next = head;
        head.next = null;

        return newNode;
    }

    public static Node reverseThroughStack(Node head) {
        Stack<Node> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        Node newHead = null;

        if (!stack.isEmpty()) {
            Node temp = stack.pop();
            newHead = temp;

            while(!stack.isEmpty()) {
                temp.next = stack.pop();
                temp = temp.next;
            }
            temp.next = null;
        }
        
        return newHead;
    }
}
