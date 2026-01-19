class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 1) return 0;

        int step1 = 0, step2 = 0;

        for (int c : cost) {
            int curStep = c + Math.min(step1, step2);

            step1 = step2;
            step2 = curStep;
        }

        return Math.min(step1, step2);
    }
}