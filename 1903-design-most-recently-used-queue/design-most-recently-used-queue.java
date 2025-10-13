class MRUQueue {
    List<Integer> queue;
    public MRUQueue(int n) {
        queue = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }
    
    public int fetch(int k) {
        int v = queue.remove(k - 1);
        queue.add(v);
        return v;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */