class Solution {
    public int minMeetingRooms(int[][] ints) {
        
        Arrays.sort(ints, (o1, o2) -> o1[0] - o2[0]);

        Queue<Integer> pq = new PriorityQueue<>();

        for (int[] i : ints) {
            if (!pq.isEmpty() && pq.peek() <= i[0]) {
                pq.poll();
            }
            pq.offer(i[1]);
        }

        return pq.size();
    }
}