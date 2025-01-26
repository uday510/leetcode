class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);

        return dfs(n);
    }

    private int dfs(int n) {
        if (n < 3) 
            return n;

        if (memo[n] != -1)
            return memo[n];

        return memo[n] = dfs(n - 1) + dfs(n - 2);
    }
}