class Solution {
    public long maxKelements(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>((prev, curr) -> Integer.compare(curr, prev));
        long max = 0;

        for (int num : nums)
            pq.offer( num);

        while (k-- > 0) {
            int topVal = pq.poll();
            max += topVal*1L;
            int reduced = (topVal + 2) / 3;
            pq.offer(reduced);
        }
        return max;
    }
}