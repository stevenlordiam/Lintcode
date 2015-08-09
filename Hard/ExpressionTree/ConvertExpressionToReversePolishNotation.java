/*
Given an expression string array, return the Reverse Polish notation of this expression. (remove the parentheses)

Have you met this question in a real interview? Yes
Example
For the expression [3 - 4 + 5] (which denote by ["3", "-", "4", "+", "5"]), return [3 4 - 5 +] (which denote by ["3", "4", "-", "5", "+"])
*/

class TreeNode {
	public int val;
	public String s;
	public TreeNode left, right;

	public TreeNode(int val, String ss) {
		this.val = val;
		this.s = ss;
		this.left = this.right = null;
	}

}


public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */

    int get(String a, Integer base) {
		if (a.equals("+") || a.equals("-"))
			return 1 + base;
		if (a.equals("*") || a.equals("/"))
			return 2 + base;

		return Integer.MAX_VALUE;
	}

	void dfs(TreeNode root, ArrayList<String> as) {
		if(root==null)
			return;
		if (root.left != null)
			dfs(root.left, as);
		
		if (root.right != null)
			dfs(root.right, as);
		as.add(root.s);
	}

	public ArrayList<String> convertToRPN(String[] expression) {
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
						right.left = nodeNow;

					} else {
						TreeNode left = stack.peek();
						if (left.val < right.val) {
							right.left = nodeNow;
						} else {
							left.right = nodeNow;
						}
					}
				} else {
					break;
				}
			}
			stack.push(right);
		}

		ArrayList<String> reversepolish = new ArrayList<String>();
		dfs(stack.peek().left, reversepolish);
		
		
		return reversepolish;
	}

}