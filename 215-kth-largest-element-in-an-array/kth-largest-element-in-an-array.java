class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }

        int num = pq.peek();

        for (int i : pq) {
            num = Math.min(num, i);
        }

        return num;
    }
}