class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        int cnt = 0;
        for (int idx = 0; idx < len; ++idx) {
            sum += nums[idx];
            int req = sum - k;

            if (map.containsKey(req)) 
                cnt += map.get(req);

            map.merge(sum, 1, Integer::sum);
        }

        return cnt;
    }
}