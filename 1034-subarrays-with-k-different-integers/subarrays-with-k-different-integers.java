class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        
        int l = 0, cnt = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {
            map.merge(nums[r], 1, Integer::sum);

            while (map.size() > k && l <= r) {
                map.merge(nums[l], -1, Integer::sum);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++; 
            }

            cnt += (r - l + 1);

        }

        return cnt;
    }

}