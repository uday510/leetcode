class Solution {
    public int deleteAndEarn(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int maxElement = 0;

        for (int num : nums) {
            
            map.merge(num, num, Integer::sum);
            maxElement = Math.max(maxElement, num);

        }

        int[] dp = new int[maxElement + 1];
        dp[1] = map.getOrDefault(1, 0);

        for (int idx = 2; idx <= maxElement; ++idx) {

            int pick = map.getOrDefault(idx, 0) + dp[idx - 2];
            int dont = dp[idx - 1];

            dp[idx] = Math.max(pick, dont);
        }

        return dp[maxElement];

    }
    
}