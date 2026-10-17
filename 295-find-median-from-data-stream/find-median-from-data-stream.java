class MedianFinder {

    private Queue<Integer> mxHeap;
    private Queue<Integer> mnHeap;
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
        int sz = mnHeap.size() + mxHeap.size();
        if ( (sz & 1) == 1) return mxHeap.peek();

        return (mxHeap.peek() + mnHeap.peek()) / 2.0;
    }
}

/**

1 2 3 4 5 6 


1
mxHeap: 1, 2
mnHeap: 3, 4





 */
