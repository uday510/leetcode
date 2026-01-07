class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];

        int cur = 1;
        for (int i = 0; i < n; i++) {
            p[i] = cur;
            cur *= nums[i];
        }

        cur = 1;
        for (int i = n - 1; i > -1; i--) {
            p[i] *= cur;
            cur *= nums[i];
        }

        return p;
    }
}