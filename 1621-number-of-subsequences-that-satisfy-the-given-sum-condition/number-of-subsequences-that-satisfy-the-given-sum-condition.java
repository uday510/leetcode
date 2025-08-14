class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] p = new int[n];
        int MOD = (int) 1e9 + 7;

        p[0] = 1;
        for (int i = 1; i < n; ++i) {
            p[i] = (p[i - 1] * 2) % MOD;
        }

        int cnt = 0;
        int l = 0, r = n - 1;

        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                cnt = (cnt + (p[r - l])) % MOD;
                l++;
            } else r--;
        }

        return cnt;
    }
}