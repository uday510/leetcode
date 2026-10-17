/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node cur = head;
        while (cur != null) {
            Node nd = new Node(cur.val);

            nd.next = cur.next;
            cur.next = nd;
            cur = nd.next;
        }

        cur = head;

        while (cur != null) {

            Node or = cur.random;
            Node nr = cur.next;

            if (or != null) {
                nr.random = or.next;
            }

            cur = nr.next;
        }

        Node nh = head.next;
        cur = nh;
        Node old = head;

        while (cur != null && cur.next != null) {
            old.next = old.next.next;
            cur.next = cur.next.next;

            old = old.next;
            cur = cur.next;
        }

        old.next = null;

        return nh;
    }
}