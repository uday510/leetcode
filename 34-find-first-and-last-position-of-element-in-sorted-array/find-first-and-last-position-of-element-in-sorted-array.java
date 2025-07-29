class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = bs(nums, target);
        if (l < nums.length && nums[l] != target || l >= nums.length) return new int[]{-1, -1};
        int r = bs(nums, target + 1) - 1;
        return new int[]{l, r};
    }
    private int bs (int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = (l + r) >> 1;

            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }

        return l;
    }
}