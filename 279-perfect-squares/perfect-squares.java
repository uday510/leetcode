class Solution {
    Set<Integer> set;
    Map<Integer, Integer> dp;
    public int numSquares(int n) {
        set = new HashSet<>();
        dp = new HashMap<>();

        for (int i = 1; i * i <= n; ++i) {
            set.add(i * i);
        }
        
        return dfs(n);
    }

    private int dfs(int n) {
        if (n < 1) return 0;
        if (set.contains(n)) return 1;

        if (dp.containsKey(n)) return dp.get(n);

        int min = (int) 1e9;
        for (var sq : set) {
            if (n - sq >= 0) {
                min = Math.min(min, 1 + dfs(n - sq));
            }
        }

        dp.put(n, min);
        return min;
    }
}