class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) 
            map.merge(num, 1, Integer::sum);

        for (var key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }

        int[] result = new int[k];
        int index = 0;
        while (!pq.isEmpty() && index < k) {
           result[index++] = pq.poll()[0];
        }

        return result;
    }
}