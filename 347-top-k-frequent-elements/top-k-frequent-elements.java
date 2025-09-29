class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        List<Integer>[] buckets = new ArrayList[n + 1];

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey(), freq = entry.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(key);
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i = n; i > -1 && idx < k; --i) {
            if (buckets[i] == null) continue;

            for (int key : buckets[i]) {
                res[idx++] = key;
                if (idx == k) break;
            }
        }

        return res;
    }
}