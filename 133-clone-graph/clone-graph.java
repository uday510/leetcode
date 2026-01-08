class Solution {

    Map<Node, Node> vis;

    public Node cloneGraph(Node node) {

        vis = new HashMap<>();

        return dfs(node);    
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }

        if (vis.containsKey(node)) {
            return vis.get(node);
        }

        Node cloned = new Node(node.val, new ArrayList<>());
        vis.put(node, cloned);

        for (Node nei : node.neighbors) {
            cloned.neighbors.add(dfs(nei));
        }

        return cloned;
    }
}