class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] dw = new int[n];
        int[] up = new int[n];

        int mx = 1;
        for (int i = 0; i < n; i++) {
            dw[i] = up[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    dw[i] = Math.max(dw[i], up[j] + 1);
                } else if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], dw[j] + 1);
                }
            }

            mx = Math.max(mx, Math.max(dw[i], up[i]));
        }

        return mx;
    }
}