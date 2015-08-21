/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    private Stack<TreeNode> stack = new Stack<>();  // 非递归要记得用stack
    // stack存还没有被遍历的点
    private TreeNode curt;
    
    public Solution(TreeNode root) {
        curt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (curt != null || !stack.isEmpty());
    }
    
    //@return: return next node
    public TreeNode next() {        // inorder traversal
        while (curt != null) {      // 走到最左
            stack.push(curt);
            curt = curt.left;
        }
        
        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;          // 走到右边的下一个点
        
        return node;
    }
}

/*
Analysis:
Use a stack to implement the in order traversal, do not forget to instantiate the stack first
Use Stack to store directed left children from root. When next() be called, just pop one element and process its right child as new root. 
It can satisfy O(h) memory, hasNext() in O(1) time, But next() is O(h) time

这是一道很经典的题目，考的非递归的中序遍历。其实这道题等价于写一个二叉树中序遍历的迭代器。
需要内置一个栈，一开始先存储到最左叶子节点的路径。在遍历的过程中，只要当前节点存在右孩子，则进入右孩子，存储从此处开始到当前子树里最左叶子节点的路径。

维护一个栈，从根节点开始，每次迭代地将根节点的左孩子压入栈，直到左孩子为空为止。调用next()方法时，弹出栈顶，如果被弹出的元素拥有右孩子，则以右孩子为根，将其左孩子迭代压栈。
采用根的中序遍历法将树节点保存在list中也可以实现树的迭代，但是空间复杂度O(size)，size为树的大小，不满足题目要求

Reference:
https://yusun2015.wordpress.com/2015/01/09/binary-search-tree-iterator/
http://blog.csdn.net/whuwangyi/article/details/42304407
http://yuanhsh.iteye.com/blog/2173429
https://oj.leetcode.com/discuss/20001/my-solutions-in-3-languages-with-stack
*/