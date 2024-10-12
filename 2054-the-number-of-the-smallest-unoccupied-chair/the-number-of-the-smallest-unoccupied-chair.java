class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < times.length; ++i) {
            list.add(new int[]{times[i][0], times[i][1], i});
        }

        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);

        var pq = new PriorityQueue<int[]>((o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        int currChair = 0;

        for (int[] time : list) {
            int arrives = time[0];
            int leaves = time[1];
            int index = time[2];

            while (!pq.isEmpty() && pq.peek()[0] <= arrives) {
                availableChairs.offer(pq.poll()[1]);
            }

            if (index == targetFriend) {
                return availableChairs.isEmpty() ? currChair : availableChairs.peek();
            }

            int assignedChair = availableChairs.isEmpty() ? currChair++ : availableChairs.poll();
            pq.offer(new int[]{leaves, assignedChair});
        }

        return -1;  
    }
}
