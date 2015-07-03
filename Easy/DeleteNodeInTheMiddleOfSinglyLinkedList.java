/*
Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.

Example
Given 1->2->3->4, and node 3. return 1->2->4
*/

public class Solution {
	public void deleteNode(ListNode node){
		if(node==null||node.next==null){
			return;
		}
		ListNode next = node.next;
		node.val=next.val; 				// copy node data to the next node
		node.next=next.next; 			// copy node reference to the next node, which is deleting the current node
	}
}

/*
CC150 2.3
*/