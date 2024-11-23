class Solution {
    public int climbStairs(int n) {
        int prevStep = 0;
        int currStep = 1;

        for (int i = 1; i <= n; ++i) {
            int nextStep = prevStep + currStep;

            prevStep = currStep;
            currStep = nextStep;
        }

        return currStep;
    }
}