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
    // oldNode, newNode
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        return dfs(node);
    }
    private Node dfs(Node oldNode) {
        if (oldNode == null) {
            return oldNode;
        }

        if (map.containsKey(oldNode)) {
            return map.get(oldNode);
            // return newNode corresponding to oldNode
        }

        Node cloned = new Node(oldNode.val);
        map.put(oldNode, cloned);
        for (var oldNeighbor: oldNode.neighbors) {
            Node newNeighbor = dfs(oldNeighbor);

            cloned.neighbors.add(newNeighbor);
        }

        return cloned;
    }
}