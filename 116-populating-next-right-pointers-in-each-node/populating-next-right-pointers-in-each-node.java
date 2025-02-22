class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        var queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int idx = 0; idx < size; ++idx) {
                Node currNode = queue.poll();
                if (currNode == null) continue;

                if (idx < size - 1) currNode.next = queue.peek();

                queue.offer(currNode.left);
                queue.offer(currNode.right);
            }
        }

        return root;
    }
}