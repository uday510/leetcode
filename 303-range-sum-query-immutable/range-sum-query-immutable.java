class NumArray {

    int[] pf;

    public NumArray(int[] nums) {
        pf = new int[nums.length];

        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            pf[i] = cur;
        }
    }
    
    public int sumRange(int l, int r) {
        if (l == 0) return pf[r];

        return pf[r] - pf[l - 1];
    }
}
