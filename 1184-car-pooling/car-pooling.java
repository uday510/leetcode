class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = 0;

        for (int[] t : trips) 
            n = Math.max(n, t[2]);

        int[] dp = new int[n + 1];

        for (int[] t : trips) {
            int p = t[0], u = t[1], v = t[2];

            dp[u] += p;
            dp[v] -= p;
        }

        int cur = 0;

        for (int d : dp) {
            if (cur > capacity) return false;
            cur += d;
        }

        return true;
    }
}


/**


 */