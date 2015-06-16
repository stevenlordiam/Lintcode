/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Have you met this question in a real interview? Yes
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
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

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> currLevel = new Stack<TreeNode>();  // use stack
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        
        currLevel.push(root);
        boolean normalOrder = true;

        while (!currLevel.isEmpty()) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);

                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }

            result.add(currLevelResult);

            tmp = currLevel;            // swap currLevel and nextLevel (WHEN currLevel IS EMPTY!!!, out of the while loop so here, nextLevel is empty)
            currLevel = nextLevel;
            nextLevel = tmp;

            normalOrder = !normalOrder;
        }

        return result;

    }
}

/*这道题其实还是树的层序遍历Binary Tree Level Order Traversal，这里稍微做了一点变体，就是在遍历的时候偶数层自左向右，而奇数层自右向左。
在Binary Tree Level Order Traversal中我们是维护了一个队列来完成遍历，而在这里为了使每次都倒序出来，我们很容易想到用栈的结构来完成这个操作。
有一个区别是这里我们需要一层一层的来处理（原来可以按队列插入就可以，因为后进来的元素不会先处理），所以会同时维护新旧两个栈，一个来读取，一个存储下一层结点。
总体来说还是一次遍历完成，所以时间复杂度是O(n)，空间复杂度最坏是两层的结点，所以数量级还是O(n)（满二叉树最后一层的结点是n/2个）
上面的算法其实还是一次广度优先搜索，只是在读取每一层结点交替的交换顺序*/