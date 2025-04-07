class Solution {
    public int tribonacci(int n) {
        if (n == 0) return n;
        int s1 = 0, s2 = 1, s3 = 1;

        for (int idx = 3; idx <= n; ++idx) {
            int s4 = s1 + s2 + s3;
            s1 = s2;
            s2 = s3;
            s3 = s4;
        }

        return s3;
    }
}