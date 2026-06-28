class Solution {
    public int longestArithSeqLength(int[] arr) {
        
        int n = arr.length, mx = 1;
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int r = 0; r < n; r++) {
            dp[r] = new HashMap<>();

            for (int l = 0; l < r; l++) {

                int dif = arr[r] - arr[l];
                int len = dp[l].getOrDefault(dif, 1) + 1;

                int curMax = Math.max(dp[r].getOrDefault(dif, 1), len);

                dp[r].put(dif, curMax);

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