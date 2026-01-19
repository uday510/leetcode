class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;

        int step1 = 1, step2 = 1;

        for (int step = 2; step <= n; step++) {
            int curStep = step1 + step2;
            
            step1 = step2;
            step2 = curStep;
        }

        return step2;
    }
}