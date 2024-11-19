class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = bisectLeft(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[] {-1, -1};
        }

        int right = bisectLeft(nums, target+1)-1;

        return new int[] {left, right};
        
    }
    private int bisectLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}