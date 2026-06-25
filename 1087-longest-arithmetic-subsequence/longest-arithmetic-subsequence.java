class Solution {
    public int longestArithSeqLength(int[] arr) {
        int n = arr.length;
        if (n <= 2) return n;

        Map<Integer, Integer>[] dp = new HashMap[n];
        int mx = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {

                int dif = arr[j] - arr[i];
                int len = dp[j].getOrDefault(dif, 1) + 1;
                int curMax = Math.max(dp[i].getOrDefault(dif, 0), len);
                dp[i].put(dif, curMax);

                mx = Math.max(mx, curMax);
            }
        }

        return mx;
    }
}