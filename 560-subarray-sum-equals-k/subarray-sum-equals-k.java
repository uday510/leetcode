class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0, sum = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int req = sum - k;

            if (map.containsKey(req)) cnt += map.get(req);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }
}

// 0 : 1
// 1: 1
// 4 : 1
// 10: 1
// [2, 3, 5] k = 5
