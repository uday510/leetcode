class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.merge(num, 1, Integer::sum);


        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[pq.size()];
        int i = 0;

        while (!pq.isEmpty()) res[i++] = pq.poll();

        return res;
    }
}