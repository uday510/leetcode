class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node currNode = head;
        while (currNode != null) {
            Node newNode = new Node(currNode.val);

            newNode.next = currNode.next;
            currNode.next = newNode;

            currNode = newNode.next;
        }

        currNode = head;
        while (currNode != null) {
            Node newNode = currNode.next;
            Node oldRandom = currNode.random;

            if (oldRandom != null) {
                newNode.random = oldRandom.next;
            }

            currNode = newNode.next;
        }

        Node newHead = head.next;
        Node newNode = newHead;
        Node oldNode = head;

        while (newNode != null && newNode.next != null) {
            oldNode.next = oldNode.next.next;
            newNode.next = newNode.next.next;

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        oldNode.next = null;
        return newHead;
    }
}