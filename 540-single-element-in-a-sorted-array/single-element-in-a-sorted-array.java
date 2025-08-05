class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = (l + r) >> 1;

            if (m % 2 == 0) {
                if (nums[m] == nums[m + 1]) l = m + 1;
                else r = m;
            } else {
                if (nums[m] != nums[m + 1]) l = m + 1;
                else r = m; 
            }
        }

        return nums[l];
    }
}