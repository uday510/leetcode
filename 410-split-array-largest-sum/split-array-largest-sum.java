class Solution {

    int k;
    int[] nums;

    public int splitArray(int[] nums, int k) {
        this.nums = nums;
        this.k = k;

        int l = 1;
        int r = Arrays.stream(nums).sum();

        if (r == 0) return 0;
        
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (canSplit(m)) {
                r = m;
            }
            else l = m + 1;
        }

        return l;
    }

    private boolean canSplit(int limit) {
        int curr = 0;
        int x = 1;

        for (int num : nums) {
            if (num > limit || x > k) return false;
            if (num + curr > limit) {
                curr = num;
                x++;
            } else curr += num;
        }

        return x <= k;
    }
}