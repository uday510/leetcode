class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Node> map = new HashMap<>();

        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    queue.offer(nei);
                }

                map.get(cur).neighbors.add(map.get(nei));
            } 
        }
        
        return map.get(node);
    }
}