/*
Given an expression string array, return the final result of this expression

Have you met this question in a real interview? Yes
Example
For the expression 2*6-(23+7)/(1+2), input is

[
  "2", "*", "6", "-", "(",
  "23", "+", "7", ")", "/",
  (", "1", "+", "2", ")"
],
return 2

Note
The expression contains only integer, +, -, *, /, (, )
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

	public int evaluateExpression(String[] expression) {
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
		String[] str = new String[reversepolish.size()];
		reversepolish.toArray(str);
		//System.out.println(as);
		
		return evalreversepolish(str);
	}

	int evalreversepolish(String[] tokens) {
		int returnValue = 0;
		String operators = "+-*/";

		Stack<String> stack = new Stack<String>();

		for (String ss : tokens) {
			if (!operators.contains(ss)) {
				stack.push(ss);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				if (ss.equals("+")) {
					stack.push(String.valueOf(a + b));
				} else if (ss.equals("-")) {
					stack.push(String.valueOf(b - a));
				} else if (ss.equals("*")) {
					stack.push(String.valueOf(a * b));
				} else if (ss.equals("/")) {
					stack.push(String.valueOf(b / a));
				}
			}
		}
		if(stack.isEmpty())
			returnValue = 0;
		else 
			returnValue = Integer.valueOf(stack.pop());

		return returnValue;
	}
}