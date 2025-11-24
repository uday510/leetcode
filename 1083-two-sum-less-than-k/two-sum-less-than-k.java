class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int max = -1;

        while (l < r) {
            int cur = nums[l] + nums[r];
            if (cur < k) l++;
            else r--;
            if (cur < k) max = Math.max(max, cur);
        }

        return max;
    }
}