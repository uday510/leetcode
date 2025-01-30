class Solution {
    Map<Integer, Integer> points;
    int[] dp;
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        points = new HashMap<>();

        for (int num : nums) {
            max = Math.max(num, max);
            points.put(num, points.getOrDefault(num, 0) + num);
        }

        dp = new int[max + 1];
        Arrays.fill(dp, -1);
        dp[1] = points.getOrDefault(1, 0);

        return dfs(max);
    }

    private int dfs(int num) {
        if (num < 0) {
            return 0;
        }

        if (num == 1) {
            return points.getOrDefault(1, 0);
        }

        if (dp[num] != -1) {
            return dp[num];
        }

        int take = points.getOrDefault(num, 0) + dfs(num - 2);
        int dont = dfs(num - 1);

        return dp[num] = Math.max(take, dont);
    }
}