/*
You have two every large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.

Have you met this question in a real interview? Yes
Example
T2 is a subtree of T1 in the following case:

       1                3
      / \              / 
T1 = 2   3      T2 =  4
        /
       4
T2 isn't a subtree of T1 in the following case:

       1               3
      / \               \
T1 = 2   3       T2 =    4
        /
       4
Note
A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical
*/

public class Solution {
	public boolean isSubtree(TreeNode T1, TreeNode T2){
		if(T2 == null){ 		// The empty tree is always a subtree (REMEMBER THIS!!!)
			return true;
		}
		return subTree(T1, T2);
	}

	public boolean subTree(TreeNode r1, TreeNode r2){
		if(r1 == null){
			return false; 
		}
		if(r1.val == r2.val){	 		// found a node in T1 matching the root of T2
			if(matchTree(r1, r2)) 	return true;
		}
		return (subTree(r1.left, r2) || subTree(r1.right, r2));
	}

	public boolean matchTree(TreeNode r1, TreeNode r2){ 		// check if two trees are identical
		if(r2 == null && r1 == null){
			return true;
		}
		if(r1 == null || r2 == null){
			return false;
		}
		if(r1.val != r2.val){
			return false;
		}
		return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
	}
}

// CC150 4.8