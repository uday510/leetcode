class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, cnt = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int req = sum - k;
            Integer val = map.get(req);
            if (val != null) cnt += val;

            map.merge(sum, 1, Integer::sum);
        }

        return cnt;
    }
}