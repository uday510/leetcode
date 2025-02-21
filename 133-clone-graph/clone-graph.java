class Solution {
    Map<Node, Node> visited;
    public Node cloneGraph(Node node) {
        visited = new HashMap<>();

        return dfs(node);        
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clonedNode = new Node(node.val, new ArrayList<>());
        visited.put(node, clonedNode);
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(dfs(neighbor));
        }

        return clonedNode;
    }
}