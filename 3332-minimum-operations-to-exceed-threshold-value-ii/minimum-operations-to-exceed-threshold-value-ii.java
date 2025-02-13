class Solution {
    public int minOperations(int[] nums, int k) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer((long) num);
        }

        int operations = 0;
        while (pq.size() > 1 && pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();

            long z = Math.min(x, y) * 2 + Math.max(x, y);

            pq.offer(z);
            operations++;
        }

        return operations;

    }
}