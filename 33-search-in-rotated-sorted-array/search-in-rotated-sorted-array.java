class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) >> 1;

            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) {
                if (target >= nums[l] && nums[m] > target) r = m - 1;
                else l = m + 1;
            } else {
                if (target <= nums[r] && target > nums[m]) l = m + 1;
                else r = m - 1;
            }
        }

        return -1; 
    }
}

/**

0   1   2   3   4   5   6
4,  5,  6,  7,  0,  1,  2



 */