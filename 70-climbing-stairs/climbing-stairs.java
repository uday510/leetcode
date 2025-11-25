class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int step1 = 0, step2 = 1;

        for (int i = 1; i <= n; i++) {
            int step3 = step1 + step2;
            step1 = step2;
            step2 = step3;
        }

        return step2;
    }
}