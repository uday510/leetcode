class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> map.get(a)));


        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key= e.getKey();
            pq.offer(key);

            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        int idx = 0;

        while (!pq.isEmpty()) {
            res[idx++] = pq.poll();
        }

        return res;
    }
}