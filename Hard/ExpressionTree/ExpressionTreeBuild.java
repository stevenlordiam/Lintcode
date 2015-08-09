/*
The structure of Expression Tree is a binary tree to evaluate certain expressions. All leaves of the Expression Tree have an number string value. All non-leaves of the Expression Tree have an operator string value.

Now, given an expression array, build the expression tree of this expression, return the root of this expression tree.

Have you met this question in a real interview? Yes
Example
For the expression (2*6-(23+7)/(1+2)) (which can be represented by ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]). The expression tree will be like

                 [ - ]
             /          \
        [ * ]              [ / ]
      /     \           /         \
    [ 2 ]  [ 6 ]      [ + ]        [ + ]
                     /    \       /      \
                   [ 23 ][ 7 ] [ 1 ]   [ 2 ] .
After building the tree, you just need to return root node [-].

Clarification
See wiki: Expression Tree
*/

class TreeNode {
	public int val;
	public String s;
	public ExpressionTreeNode root; 

	public TreeNode(int val, String ss) {
		this.val = val;
		this.root = new ExpressionTreeNode(ss);
	}

}

public class Solution {

	int get(String a, Integer base) {
		if (a.equals("+") || a.equals("-"))
			return 1 + base;
		if (a.equals("*") || a.equals("/"))
			return 2 + base;

		return Integer.MAX_VALUE;
	}



	public ExpressionTreeNode build(String[] expression) {
		// write your code here
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = null;
		int val = 0;
		Integer base = 0;
		for (int i = 0; i <= expression.length; i++) {
			if(i != expression.length)
			{
				
				if (expression[i].equals("(")) {
					base += 10;
					continue;
				}
				if (expression[i].equals(")")) {
					base -= 10;
					continue;
				}
				val = get(expression[i], base);

			}
			TreeNode right = i == expression.length ? new TreeNode(
					Integer.MIN_VALUE, "") : new TreeNode(val,
					expression[i]);
			while (!stack.isEmpty()) {
				if (right.val <= stack.peek().val) {
					TreeNode nodeNow = stack.pop();

					if (stack.isEmpty()) {
						right.root.left = nodeNow.root;

					} else {
						TreeNode left = stack.peek();
						if (left.val < right.val) {
							right.root.left = nodeNow.root;
						} else {
							left.root.right = nodeNow.root;
						}
					}
				} else {
					break;
				}
			}
			stack.push(right);
		}

	
		
		return stack.peek().root.left;
	}


}