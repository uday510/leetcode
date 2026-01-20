class Solution {
    public int deleteAndEarn(int[] nums) {
        
        Map<Integer, Integer> cnts = new HashMap<>();
        int mx = -1;

        for (int num : nums) {
            cnts.put(num, cnts.getOrDefault(num, 0) + num);
            mx = Math.max(mx, num);
        }

        int[] dp = new int[mx + 1];
        dp[1] = cnts.getOrDefault(1, 0);

        for (int i = 2; i <= mx; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + cnts.getOrDefault(i, 0));
        }

        return dp[mx];
    }
}

/**

2 - 4
3 - 9
4 - 4


p0 = 0, p1 = 0



 */