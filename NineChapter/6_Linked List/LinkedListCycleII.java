/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Have you met this question in a real interview? Yes
Example
Given -21->10->4->5, tail connects to node index 1，返回10

Challenge
Follow up:
Can you solve it without using extra space?
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null) {
            return null;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {      // they meet at the point where cycle starts
            if(fast==null || fast.next==null)
                return null;        // no cycle
            fast = fast.next.next;
            slow = slow.next;
        } 
        
        while (head != slow.next) { // same speed after they meet, and they will meet again at the point where cycle starts
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}