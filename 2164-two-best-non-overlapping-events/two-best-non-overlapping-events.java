class Solution {
    public int maxTwoEvents(int[][] E) {
        Arrays.sort(E, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        
        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(k -> k[1]));

        int maxSum = 0, curSum = 0;
        for (var e : E) {

            while (!pq.isEmpty() && pq.peek()[1] < e[0]) {
                curSum = Math.max(curSum, pq.poll()[2]);
            }

            pq.offer(e);
            maxSum = Math.max(maxSum, curSum + e[2]);
        }

        return maxSum;
    }
}