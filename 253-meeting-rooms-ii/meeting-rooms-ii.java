class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Queue<Integer> pq = new PriorityQueue<>();
        for (int idx = 0; idx < intervals.length; ++idx) {
            if (!pq.isEmpty() && pq.peek() <= intervals[idx][0]) {
                pq.poll();
            }
            pq.offer(intervals[idx][1]);
        }

        return pq.size();
    }
}