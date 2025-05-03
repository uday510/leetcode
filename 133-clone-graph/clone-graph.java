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
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Node> map = new HashMap<>();
        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node nei : curr.neighbors) {
                if (map.containsKey(nei)) {
                    map.get(curr).neighbors.add(map.get(nei));
                    continue;
                }
                map.put(nei, new Node(nei.val));
                map.get(curr).neighbors.add(map.get(nei));
                queue.offer(nei);
            }
        }

        return map.get(node);
    }
}