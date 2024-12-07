class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {

        var priorityQueue = new PriorityQueue<Integer>();
        Set<Integer> seen = new HashSet<>();

        for (int num : banned) {
            seen.add(num);
        }

        for (int idx = 1; idx <= n; ++idx) {
            if (!seen.contains(idx)) {
                priorityQueue.offer(idx);
            }
        }

        System.out.println(priorityQueue);

        int cnt = 0;
        int curr = 0;

        while (!priorityQueue.isEmpty() && curr + priorityQueue.peek() <= maxSum) {
            curr += priorityQueue.poll();
            ++cnt;
        }

        return cnt;
    }
}