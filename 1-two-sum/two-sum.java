class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {-1, -1};
        
        for (int idx = 0; idx < nums.length; ++idx) {
            int req = target - nums[idx];
            if (map.containsKey(req)) {
                result[0] = map.get(req);
                result[1] = idx;
                break;
            }
            map.put(nums[idx], idx);
        }
        return result;
    }
}