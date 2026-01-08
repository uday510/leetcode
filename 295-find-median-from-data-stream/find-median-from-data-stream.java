class MedianFinder {

    Queue<Integer> mxHeap;
    Queue<Integer> mnHeap;

    public MedianFinder() {
        mxHeap = new PriorityQueue<>(Collections.reverseOrder());
        mnHeap = new PriorityQueue<>();    
    }
    
    public void addNum(int num) {
        mxHeap.offer(num);
        mnHeap.offer(mxHeap.poll());

        if (mxHeap.size() < mnHeap.size()) {
            mxHeap.offer(mnHeap.poll());
        }

    }
    
    public double findMedian() {
        int m = mnHeap.size() + mxHeap.size();

        if ( (m & 1) == 1) return mxHeap.peek();

        return ( mxHeap.peek() + mnHeap.peek() ) / 2.0;
    }
}
