class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int cur = nums[0];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * cur;
            cur = nums[i];
        }

        cur = 1;
        for (int i = n - 1; i > -1; i--) {
            res[i] *= cur;
            cur *= nums[i];
        }

        return res;
    }
}