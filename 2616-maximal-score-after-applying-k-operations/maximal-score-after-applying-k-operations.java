class Solution {
    public long maxKelements(int[] nums, int k) {
        var pq = new PriorityQueue<Long>((prev, curr) -> Long.compare(curr, prev));
        long max = 0;

        for (int num : nums)
            pq.offer((long) num);

        while (k-- > 0) {
            long topVal = pq.poll();
            max += topVal;
            long reduced = (topVal + 2) / 3;
            pq.offer(reduced);
        }
        return max;
    }
}