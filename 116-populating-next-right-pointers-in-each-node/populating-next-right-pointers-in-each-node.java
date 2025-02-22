/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int idx = 0; idx < size; ++idx) {
                Node currNode = queue.poll();
                if (currNode == null) continue;
                System.out.println(currNode.val);
                if (prev == null) prev = currNode;
                else prev.next = currNode;
                prev = currNode;

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }

            if (prev != null) prev.next = null;
        }

        return root;
    }
}