class MinStack {

    private Node head;
    
    public MinStack() {
        head = new Node(-1, Integer.MAX_VALUE, null);    
    }
    
    public void push(int val) {
        head = new Node(val, Math.min(head.min, val), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    private class Node {
        int val, min;
        Node next;

        Node (int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
