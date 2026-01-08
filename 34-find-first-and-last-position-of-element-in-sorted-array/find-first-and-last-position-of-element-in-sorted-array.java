class Solution {

    int[] nums;
    int n;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.n = nums.length;

        int l = bs(target);
        if (l == n || nums[l] != target) return new int[] {-1, -1};
        int r = bs(target + 1) - 1;

        return new int[] {l, r};
    }

    private int bs(int target) {
        int l = 0, r = n;

        while (l < r) {
            int m = (l + r) >> 1;

            if (nums[m] < target) l = m + 1;
            else r = m;
        }
        
        return l;
    }
}