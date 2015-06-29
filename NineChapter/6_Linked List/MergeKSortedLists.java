/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Have you met this question in a real interview? Yes
Example
Given [2->4->null,null,-1->null], return  -1->2->4->null
*/

public class Solution {
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            } else if (right == null) {
                return -1;
            }
            return left.val - right.val;
        }
    };
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {    // 添加链表中head后面的node到heap中
                heap.add(head.next);
            }
        }
        return dummy.next;
    }
}