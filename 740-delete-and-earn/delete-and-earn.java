class Solution {
    public int deleteAndEarn(int[] nums) {
        
        Map<Integer, Integer> points = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            max = Math.max(num, max);
            points.merge(num, num, Integer::sum);
        }

        int[] dp = new int[max + 1];
        dp[1] = points.getOrDefault(1, 0);
        
        int maxPoints = dp[1];

        for (int i = 2; i <= max; ++i) {
            int pick = points.getOrDefault(i, 0) + dp[i - 2];
            int dont = dp[i - 1];
            int curr = Math.max(pick, dont);

            dp[i] = curr;
            maxPoints = Math.max(curr, maxPoints);
        }

        return maxPoints;
    }
}