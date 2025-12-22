package com.example.dsa;

import java.util.PriorityQueue;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
*/

public class LT_023_merge_k_sorted_lists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode l4 = null;
        ListNode[] lists = {l1, l2, l3};

        ListNode res = mergeKLists(lists);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a,b) -> (a.val - b.val)
        );

        for (int i=0; i<lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();

            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    public static ListNode mergeKLists_sequential(ListNode[] lists) {
        int min = 0;
        int k = lists.length;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(min != Integer.MAX_VALUE) {
            min = Integer.MAX_VALUE;
            int selectedList = -1;
            
            for (int i=0; i<k; i++) {
                if (lists[i] == null) {
                    continue;
                }
            
                if (lists[i].val < min) {
                    min = lists[i].val;
                    selectedList = i;
                }
            }

            if (selectedList != -1) {
                ListNode temp = lists[selectedList].next;
                curr.next = lists[selectedList];
                lists[selectedList] = temp;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
