/*
Sort a linked list using insertion sort.

Have you met this question in a real interview? Yes
Example
Given 1->3->2->0->null, return 0->1->2->3->null.
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;  // reverse node and head
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummy.next;
    }
}