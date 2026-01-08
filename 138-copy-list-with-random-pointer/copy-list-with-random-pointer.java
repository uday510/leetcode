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
            Node newNode = new Node(cur.val);

            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        cur = head;

        while (cur != null) {

            Node oldRandom = cur.random;
            Node newNode = cur.next;


            if (oldRandom != null) {
                newNode.random = oldRandom.next;
            }

            cur = newNode.next;
        }

        Node newHead = head.next;
        cur = newHead;
        Node old = head;

        while (cur != null && cur.next != null) {
            old.next = old.next.next;
            cur.next = cur.next.next;

            old = old.next;
            cur = cur.next;
        }

        old.next = null;

        return newHead;
    }
}