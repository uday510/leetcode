class Solution {
    public int climbStairs(int n) {
        // return dfs(n);
        int step1 = 0;
        int step2 = 1;
        
        for (int i = 1; i <= n; ++i) {
            int currStep = step1 + step2;
            step1 = step2;
            step2 = currStep;
        }
        return step2;
    }
    public int dfs(int n) {
        if ( n <= 1) return 1;
        // if (n <= 0) return 0;
        
        return dfs(n-1) + dfs(n-2);
    }
}