class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int t1 = 0;
        int t2 = 0;

        for (int idx = 0; idx < cost.length; ++idx) {
            int curr = Math.min(t1, t2) + cost[idx];
            t1 = t2;
            t2 = curr;
        }
        return Math.min(t1, t2);
    }
}