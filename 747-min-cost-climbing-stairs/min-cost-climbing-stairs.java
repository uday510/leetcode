class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        if (cost.length < 1) return 0;

        int s0 = 0, s1 = 0;

        for (int c : cost) {
            int s2 = c + Math.min(s0, s1);

            s0 = s1;
            s1 = s2;
        }

        return Math.min(s0,  s1);
    }
}