class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 1) return 0;

        int step1 = 0, step2 = cost[0];

        for (int i = 1; i < cost.length; i++) {
            int c = cost[i];
            int curStep = c + Math.min(step1, step2);

            step1 = step2;
            step2 = curStep;
        }

        return Math.min(step1, step2);
    }
}