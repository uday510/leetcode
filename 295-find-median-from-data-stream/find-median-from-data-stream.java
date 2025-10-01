class MedianFinder {

    // [1, 2, 3, 4, 5]
    PriorityQueue<Integer> maxHeap; // first half [1, 2, 3]
    PriorityQueue<Integer> minHeap; // second half = [4, 5]

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();    
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}

/**

maxHeap - stores first half 
minHeap - stores second half

 */