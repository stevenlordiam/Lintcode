/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Have you met this question in a real interview? Yes
Example
An example:

  2
 / \
1   3
   /
  4
   \
    5
The above binary tree is serialized as {2,1,3,#,#,4,#,#,5} (in level order).
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution { // inorder traversal ascending order
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    
    public boolean isValidBST(TreeNode root) {    // inorder traversal
        // write your code here
        if(root == null) {
            return true;
        }
        if(!isValidBST(root.left)) {  // 左
            return false;
        }
        if (!firstNode && lastVal >= root.val) {  // 中
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if(!isValidBST(root.right)) {   // 右
            return false;
        }
        return true;
    }
}