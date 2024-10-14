class Solution {
    public long maxKelements(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>((prev, curr) -> Integer.compare(curr, prev));
        long max = 0;

        for (int num : nums)
            pq.offer( num);

        while (k-- > 0) {
            int topVal = pq.poll();
            max += topVal*1L;
            pq.offer((topVal + 2) / 3);
        }
        return max;
    }
}