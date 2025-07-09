class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int required = target - nums[i];

            Integer element = seen.get(required);
            if (element != null) return new int[] {element, i};

            seen.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}