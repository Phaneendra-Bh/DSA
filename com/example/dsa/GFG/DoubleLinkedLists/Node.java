package com.example.dsa.GFG.DoubleLinkedLists;

public class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
