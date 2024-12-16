class Solution {

    private PriorityQueue<int[]> priorityQueue;
    private int len;
    private int current;
    public int[] getFinalState(int[] nums, int k, int multiplier) {
       intialize(nums, k);

       while (current-- > 0) {
        int[] polled = priorityQueue.poll();
        polled[0] = polled[0] * multiplier;

        priorityQueue.offer(polled);
       }
       
       int[] result = getFinalState();

       return result;
    }

    private void intialize(int[] nums, int k) {
        priorityQueue = new PriorityQueue<>((x, y) -> {
           if (x[0] == y[0]) {
            return Integer.compare(x[1], y[1]);
           }
           return Integer.compare(x[0], y[0]);
        });

        len = nums.length;
        current = k;

        for (int idx = 0; idx < len; ++idx) {
            priorityQueue.offer(new int[]{nums[idx], idx});
        }
    }
    
    private int[] getFinalState() {
        int[] result = new int[len];

        while (!priorityQueue.isEmpty()) {
            
            int[] polled = priorityQueue.poll();
            result[polled[1]] = polled[0];
       }

       return result;
    }
}