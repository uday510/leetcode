
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node currNode = head;

        while (currNode != null) {
            Node newNode = new Node(currNode.val);
            newNode.next = currNode.next;
            currNode.next = newNode;
            currNode = newNode.next;
        }

        currNode = head;
        while (currNode != null) {
            Node oldRandom = currNode.random;
            Node newNode = currNode.next;
            if (oldRandom != null)
                newNode.random = oldRandom.next;
            
            currNode = newNode.next;
        }

        Node newHead = head.next;
        Node newNode = newHead;
        Node oldNode = head;

         while (newNode != null) {
            oldNode.next = (oldNode.next != null) ? oldNode.next.next : null;
            newNode.next = (newNode.next != null) ? newNode.next.next : null;

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return newHead;
    }
}