/*
Find the nth to last element of a singly linked list. 

The minimum number of nodes in list is n.

Have you met this question in a real interview? Yes
Example
Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
*/

public class Solution {
    public ListNode nthToLast(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        int count = 0;
        ListNode node = head;
        while (node != null && count < n) {
            node = node.next;
            count++;
        }
        while (node != null) {
            node = node.next;
            head = head.next;
        }
        return head;
    }
}