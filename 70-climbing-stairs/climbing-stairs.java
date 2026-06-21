class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;

        int s1 = 1, s2 = 1;

        for (int s = 2; s <= n; s++) {
            int s3 = s1 + s2;
            s1 = s2;
            s2 = s3;
        }

        return s2;
    }
}