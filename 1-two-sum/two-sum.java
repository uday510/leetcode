class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            int req = target - nums[i];
            if (map.containsKey(req)) {
                res[0] = map.get(req);
                res[1] = i;
                break;
            }

            map.put(nums[i], i);
        }

        return res;
    }
}