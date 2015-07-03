/*
Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)

Have you met this question in a real interview? Yes
Example
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}
*/

/**
 * Definition for Undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution { 	// http://www.cnblogs.com/easonliu/p/4606255.html
public:
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    void dfs(vector<UndirectedGraphNode*> &nodes, vector<int> &path,
            unordered_set<UndirectedGraphNode*> &visit, UndirectedGraphNode* n) {
        visit.insert(n);
        path.push_back(n->label);
        for (auto &nn : n->neighbors) if (visit.find(nn) == visit.end()) {
            dfs(nodes, path, visit, nn);
        }
    }
    vector<vector<int>> connectedSet(vector<UndirectedGraphNode*>& nodes) {
        // Write your code here
        unordered_set<UndirectedGraphNode*> visit;
        vector<vector<int>> res;
        vector<int> path;
        for (auto &n : nodes) {
            if (visit.find(n) == visit.end()) {
                path.clear();
                dfs(nodes, path, visit, n);
                sort(path.begin(), path.end());
                res.push_back(path);
            } 
        }
        return res;
    }
};