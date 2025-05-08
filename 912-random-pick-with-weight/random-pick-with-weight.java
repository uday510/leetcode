class Solution {
    int[] psum;
    int[] w;
    public Solution(int[] w) {
        int n = w.length;
        psum = new int[n];
        this.w = w;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += w[i];
            psum[i] = sum;
        }
    }
    
    public int pickIndex() {
        int val = new Random().nextInt(psum[psum.length - 1]) + 1;
        int left = 0, right = psum.length;

        while (left < right) {
            int midIdx = (left + right) >> 1;
            if (psum[midIdx] < val) left = midIdx + 1;
            else right = midIdx;
        }

        return left;
    }
}