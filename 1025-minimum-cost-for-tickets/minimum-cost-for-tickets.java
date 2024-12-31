class Solution {
    int[] arr = new int[] {1, 7, 30};
    int[][] dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[366][1000];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dfs(0, 0, days, costs);
    }

    private int dfs(int index, int pass, int[] days, int[] costs) {
        if (index >= days.length) {
           return 0;
        }


        if (dp[index][pass] != -1) {
            return dp[index][pass];
        }

        if (pass >= days[index]) {
            int result = dfs(index + 1, pass, days, costs);
            dp[index][pass] = result;
            return result;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; ++i) {
            int newPass = days[index] + arr[i] - 1;
            min = Math.min(min, dfs(index + 1, newPass, days, costs) + costs[i]);
        }

        dp[index][pass] = min;

        return min;
    }
}