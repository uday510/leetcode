class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int leftIdx = 0;
        int rightIdx = 0;
        int len = nums.length;
        int maxLength = 1;

        while (rightIdx < len) {

            map.put(nums[rightIdx], map.getOrDefault(nums[rightIdx], 0) + 1);
            while (leftIdx < len && map.get(nums[rightIdx]) > k) {
                map.put(nums[leftIdx], map.get(nums[leftIdx]) - 1);
                leftIdx++;
            }

            maxLength = Math.max(maxLength, (rightIdx - leftIdx + 1));
            rightIdx++;
        }

        return maxLength;
    }
}