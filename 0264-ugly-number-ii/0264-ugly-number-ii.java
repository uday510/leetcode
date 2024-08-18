class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        
        set.add(1L);
        pq.offer(1L);
        
        long ugly = 1;
        
        for (int i = 0; i < n; ++i) {
            ugly = pq.poll();
            for (int prime : new int[]{2,3,5}) {
                long nextUgly = prime * ugly;
                if (set.add(nextUgly)) {
                    pq.offer(nextUgly);
                }
            }
        }
        return (int) ugly;
    }
}