class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> seen = new HashMap<>();
        int[] result = {-1, -1};

        for (int i = 0; i < nums.length; ++i) {
            int required = target - nums[i];

            if (seen.containsKey(required)) {
                result[0] = seen.get(required);
                result[1] = i;
                break;
            }

            seen.put(nums[i], i);
        }

        return result;
    }
}