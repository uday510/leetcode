class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int leftIdx = 0;
        int rightIdx = 0;
        int len = nums.length;
        int maxLength = 1;

        for (; rightIdx < len;) {

            map.put(nums[rightIdx], map.getOrDefault(nums[rightIdx], 0) + 1);
            for (; leftIdx < len && map.get(nums[rightIdx]) > k; ++leftIdx) {
                map.put(nums[leftIdx], map.get(nums[leftIdx]) - 1);
            }

            maxLength = Math.max(maxLength, (rightIdx - leftIdx + 1));
            rightIdx++;
        }

        return maxLength;
    }
}