class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] pf = new int[n];
        pf[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            pf[i] = pf[i - 1] ^ nums[i];
        }

        int[] res = new int[n];

        int mask = (1 << maximumBit) - 1;

        for (int i = 0; i < n; ++i) {
            int curr = pf[n-1-i];
            res[i] = curr ^ mask;
        }

        return res;
    }
}