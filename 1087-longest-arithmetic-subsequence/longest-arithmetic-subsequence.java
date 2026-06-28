class Solution {
    public int longestArithSeqLength(int[] arr) {
        
        int n = arr.length, mx = 1;
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int cur = 0; cur < n; cur++) {
            dp[cur] = new HashMap<>();

            for (int prev = 0; prev < cur; prev++) {

                int dif = arr[cur] - arr[prev];
                int len = dp[prev].getOrDefault(dif, 1) + 1;
                int curMax = Math.max(dp[cur].getOrDefault(dif, 1), len);

                dp[cur].put(dif, curMax);

                mx = Math.max(mx, curMax);
            }
        }

        return mx;
    }
}

/**

0: [ ]
1: [ 3:2 ]
2: [ 6:2, 3:3 ]
3: [ 9:2, 6:2 3:4 ]


*/