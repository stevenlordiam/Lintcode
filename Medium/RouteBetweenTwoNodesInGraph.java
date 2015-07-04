/*
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

Have you met this question in a real interview? Yes
Example
Given graph:

A----->B----->C
 \     |
  \    |
   \   |
    \  v
     ->D----->E
for s = B and t = E, return true

for s = D and t = C, return false
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        if (s == t) {
            return true;
        }
        if (graph == null || graph.size() == 0 || s == null || t == null) {
            return false;
        }
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
        stack.push(s);
        while (!stack.isEmpty()) {
            DirectedGraphNode node = stack.pop();
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (neighbor == t) {
                    return true;
                }
                stack.push(neighbor);
            }
        }
        return false;
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/13/lintcode-route-between-two-nodes-in-graph/
http://blog.csdn.net/martin_liang/article/details/45799451
http://www.dotnet2005.com/2015/04/route-between-two-nodes-in-graph.html
*/