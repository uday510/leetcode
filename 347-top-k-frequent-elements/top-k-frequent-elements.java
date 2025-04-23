class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.merge(num, 1, Integer::sum);

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));

        for (int n : map.keySet()) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }

        System.out.println(pq);

        int[] topK = new int[k];
        for (int i = k - 1; i > -1; --i) {
            topK[i] = pq.poll();
        }

        return topK;
    }
}