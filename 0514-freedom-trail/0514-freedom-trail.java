class Solution {
    public int findRotateSteps(String ring, String key) {
        return dfs(ring, key, 0, 0, new Integer[ring.length()][key.length()]);
    }
    
     public int dfs(String ring, String key, int ringIndex, int keyIndex, Integer[][] dp) {
        if (keyIndex == key.length()) {
            return 0;
        }

        if (dp[ringIndex][keyIndex] != null) {
            return dp[ringIndex][keyIndex];
        }

        int minSteps = Integer.MAX_VALUE;

        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(keyIndex)) {

                int clockWise = Math.abs(ringIndex - i);
                int antiClockWise = ring.length() - clockWise;

                int steps = 1 + Math.min(clockWise, antiClockWise) 
                    + dfs(ring, key, i, keyIndex + 1, dp);

                minSteps = Math.min(minSteps, steps);
            }
        }

        dp[ringIndex][keyIndex] = minSteps;

        return minSteps;
    }
}