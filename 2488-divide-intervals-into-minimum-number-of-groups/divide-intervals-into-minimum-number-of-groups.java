class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (prev, curr) -> prev[0] - curr[0]);
        var pq = new PriorityQueue<Integer>();

        for (int[] interval : intervals) {
            
            if (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll();
            }

            pq.offer(interval[1]);
        }
        return pq.size();
    }
}

/**

[1, 5]

[1, 10]

[2, 3]

[5, 10]

[6, 8]

 */