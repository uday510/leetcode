class Solution {

    private long sum;
    private PriorityQueue<Long> priorityQueue;
    private long seconds;

    public long pickGifts(int[] gifts, int k) {
        initialize(gifts, k);

        while (seconds-- > 0 && !priorityQueue.isEmpty()) {
            long value = priorityQueue.poll(); 
            long root = (long) Math.sqrt(value); 
            
            sum -= value; 
            sum += root;

            priorityQueue.offer(root); 
        }

        return sum;
    }

    private void initialize(int[] gifts, int k) {
        sum = 0;
        priorityQueue = new PriorityQueue<>((x, y) -> Long.compare(y, x));
        seconds = k;

        for (int gift : gifts) {
            long giftValue = gift;
            sum += giftValue;
            priorityQueue.offer(giftValue);
        }
    }
}
