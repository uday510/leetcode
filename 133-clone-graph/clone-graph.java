/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

 class Solution {
    Map<Node, Node> dp;
    public Node cloneGraph(Node node) {
        dp = new HashMap<>();
        return dfs(node);
    }
    private Node dfs(Node node) {
        if (node == null) return null;

        if (dp.containsKey(node)) return dp.get(node);

        Node newNode = new Node(node.val);
        dp.put(node, newNode); 

        for (Node nei : node.neighbors) {
            newNode.neighbors.add(dfs(nei));
        }

        return newNode;
    }
}

/**


1 --> [2, 4]
2 --> [1, 3]
3 --> [4, 2]


1 -> []




 */