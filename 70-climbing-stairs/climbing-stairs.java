class Solution {
    public int climbStairs(int n) {
        int s1 = 0;
        int s2 = 1;

        for (int i = 1; i <= n; ++i) {
            int s3 = s1 + s2;
            s1 = s2;
            s2 = s3;
        }
        
        return s2;
    }
}