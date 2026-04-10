class Solution {

    private int[] w;
    private int[] psum;
    private int n;
    private Random rand = new Random();

    public Solution(int[] w) {
        this.w = w;
        this.n = w.length;
        psum = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += w[i];
            psum[i] = sum;
        }    

    }
    
    public int pickIndex() {
        
        int t = rand.nextInt(psum[n - 1]) + 1;

        int l = 0, r = n;

        while (l < r) {
            int m = l + ( ( r - l) >> 1);

            if (psum[m] < t) l = m + 1;
            else r = m;
        }

        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */