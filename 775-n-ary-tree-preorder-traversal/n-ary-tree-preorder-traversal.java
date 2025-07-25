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
    List<Integer> list;
    public List<Integer> preorder(Node root) {
        list = new ArrayList<>();
        if (root == null) return list;

        Deque<Node> st = new ArrayDeque<>();
        st.offer(root);

        while (!st.isEmpty()) {
            Node node = st.pollLast();
            if (node == null) continue;
            list.add(node.val);

            for (int i = node.children.size() - 1; i > -1; --i) {
                st.offerLast(node.children.get(i));
            }
        }

        return list;
    }
}