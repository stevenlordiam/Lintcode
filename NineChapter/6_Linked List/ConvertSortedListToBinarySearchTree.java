/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

public class Solution {

    private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size;
        current = head;
        size = getListLength(head); // 每次更新当前的链表长度, 每次从current后面取size这么长的convert成BST
        return sortedListToBSTHelper(size);
    }

    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }
}