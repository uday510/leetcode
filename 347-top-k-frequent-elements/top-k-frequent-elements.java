class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) 
            count.merge(num, 1, (a, b) -> a + b);
        
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new ArrayList<>();
        }

        for (int key : count.keySet()) {
            buckets[count.get(key)].add(key);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = buckets.length - 1; i > -1; --i) {
            for (int num : buckets[i]) {
                list.add(num);
            }
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; ++i) {
            topK[i] = list.get(i);
        }

        return topK;
    }
}