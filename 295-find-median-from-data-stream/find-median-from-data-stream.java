class MedianFinder {

    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();    
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        int m = minHeap.size() + maxHeap.size();

        if (m % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; 
        }

        return maxHeap.peek();
    }
}

/**
1, 2, 3, 4, 5

max: 1, 2, 3
min: 4, 5

 */