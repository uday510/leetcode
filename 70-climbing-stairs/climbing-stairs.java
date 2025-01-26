class Solution {
    public int climbStairs(int n) {
        int[] seen = new int[n + 1];
        seen[1] = 1;
        seen[0] = 1;

        for (int idx = 2; idx <= n; ++idx) {
            seen[idx] = seen[idx - 1] + seen[idx - 2];
        }

        return seen[n];
    }
}