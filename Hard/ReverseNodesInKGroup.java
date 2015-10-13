/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed. Only constant memory is allowed.

Example
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k == 0 || k == 1) return head;
		ListNode cur = head;
		int length = 0;
		while (cur != null){
			cur = cur.next;
			length++;
		}
		int multi = length / k;
		if(multi == 0) return head;
		ListNode preTail = null, curHead = null, curTail = null;
		ListNode preNode = null, nextNode = null;
		cur = head;
		for(int j = 0; j < multi; j++) {
			preNode = null;
			for(int i = 0; i < k; i++) {
				if(cur != null) {
					nextNode = cur.next;
					cur.next = preNode;
					preNode = cur;
				}
				if(i == 0) curTail = cur;
				if(i == (k - 1)) curHead = cur;
				cur = nextNode;
			}
			if(preTail == null) head = curHead;
			else preTail.next = curHead;
			preTail = curTail;
		}
		curTail.next = cur;
		return head;
	}
}