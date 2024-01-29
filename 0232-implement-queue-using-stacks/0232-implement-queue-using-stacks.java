class MyQueue {
    Deque<Integer> queue;
    public MyQueue() {
        queue = new ArrayDeque();
    }
    
    public void push(int x) {
        queue.offerLast(x);
    }
    
    public int pop() {
        return queue.pollFirst();
    }
    
    public int peek() {
        return queue.peekFirst();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */