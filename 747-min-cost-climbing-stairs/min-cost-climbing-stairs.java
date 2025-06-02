class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int p1 = cost[0], p2 = cost[1];

        for (int i = 2; i < cost.length; ++i) {
            int p3 = cost[i] + Math.min(p1, p2);
            p1 = p2;
            p2 = p3;
        }

        return Math.min (p1, p2);
    }
}