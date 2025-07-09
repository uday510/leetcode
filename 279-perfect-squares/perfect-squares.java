class Solution {

    Map<Integer, Integer> dp;

    public int numSquares(int n) {
        dp = new HashMap<>();

        return dfs(n);
    }

    private int dfs (int n) {
        if (n < 1) return 0;
        
        if (dp.containsKey(n)) return dp.get(n);

        int min = (int) 1e9;
        for (int i = 1; i * i <= n; ++i) {
            min = Math.min(min, 1 + dfs(n - i * i));
        }

        dp.put(n, min);
        return min;
    }
}