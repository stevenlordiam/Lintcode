/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 
return [3,2,1].

Challenge
Can you do it without recursion?
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
public class Solution { 	//Iterative
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null; // previously traversed node
        TreeNode curr = root;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.empty()) {    // ???
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
                if (curr.left != null) {    // 先左再右
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) { // traverse up the tree from the left
                if (curr.right != null) {   
                    stack.push(curr.right);
                }
            } else { // traverse up the tree from the right
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }

        return result;
    }
}

/*
//Recursive
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();

    if (root == null) {
        return result;
    }

    result.addAll(postorderTraversal(root.left));
    result.addAll(postorderTraversal(root.right));
    result.add(root.val);

    return result;   
}
*/