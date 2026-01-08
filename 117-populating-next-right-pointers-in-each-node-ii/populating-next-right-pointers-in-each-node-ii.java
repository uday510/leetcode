
class Solution {
    public Node connect(Node root) {
        Node dummy = new Node(-1);
        Node tmp = dummy;
        Node cur = root;

        while (cur != null) {
            if (cur.left != null) {
                tmp.next = cur.left;
                tmp = tmp.next;
            }

            if (cur.right != null) {
                tmp.next = cur.right;
                tmp = tmp.next;
            }

            cur = cur.next;
            if (cur == null) {
                cur = dummy.next;
                dummy = new Node(-1);
                tmp = dummy;
            }
        }

        return root;
    }
}