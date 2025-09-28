/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        return dfs(root);
    }
    private int dfs(Node node) {
        if (node == null) return 0;

        int curr = 0;
        for (Node c : node.children) {
            curr = Math.max(curr, dfs(c));
        }

        return curr + 1;
    }
}