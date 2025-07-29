class Solution {
    public int search(int[] nums, int target) {
        return bisectLeft(nums, target);
    }

    private int bisectLeft(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int mid = (l + r) >> 1;

            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }

        return l < nums.length && nums[l] == target ? l : -1;
    }

    private int bs(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
}