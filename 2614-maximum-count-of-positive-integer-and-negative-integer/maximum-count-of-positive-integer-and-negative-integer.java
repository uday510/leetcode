class Solution {
    public int maximumCount(int[] nums) {
        return Math.max(bs(0, nums), nums.length - bs(1, nums));
    }

    private int bs(int target, int[] nums) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}