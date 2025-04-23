class Solution {
    public Node copyRandomList(Node head) {
        
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            Node node = new Node(curr.val);

            node.next = curr.next;
            curr.next = node;
            curr = node.next;
        }

        curr = head;
        while (curr != null) {
            Node old = curr.random;
            Node newNode = curr.next;

            if (old != null) 
                newNode.random = old.next;

            curr = newNode.next;
        }

        Node newHead = head.next;
        Node node = newHead;
        Node old = head;

        while (node != null && node.next != null) {
            old.next = old.next.next;
            node.next = node.next.next;

            old = old.next;
            node = node.next;
        }

        old.next = null;

        return newHead;
    }
}