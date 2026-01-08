class Solution {
    public int climbStairs(int n) {
        
        if (n < 2) return n;

        int stp1 = 0, stp2 = 1;

        for (int i = 1; i <= n; i++) {
            int stp3 = stp1 + stp2;
            stp1 = stp2;
            stp2 = stp3;
        }

        return stp2;
    }
}