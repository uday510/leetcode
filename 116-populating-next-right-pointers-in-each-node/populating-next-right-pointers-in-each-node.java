class Solution {
    public Node connect(Node root) {
        Node dummyNode = new Node(0);
        Node tempNode = dummyNode;
        Node currNode = root;

        while (currNode != null) {
            if (currNode.left != null) {
                tempNode.next = currNode.left;
                tempNode = tempNode.next;
            }
            if (currNode.right != null) {
                tempNode.next = currNode.right;
                tempNode = tempNode.next;
            }
            currNode = currNode.next;
            if (currNode == null) {
                currNode = dummyNode.next;
                dummyNode.next = null;
                tempNode = dummyNode;
            }
        }
        return root;
    }
}