class Solution {

    public int findNumberOfLIS(int[] arr) {

        int n = arr.length;
        Pair[][] dp = new Pair[n + 1][n];

        return dfs(-1, 0, n, arr, dp).cnt;
    }

    private Pair dfs(int p, int c, int n, int[] arr, Pair[][] dp) {
        if (p >= n || c >= n) return new Pair(0, 1);

        if (dp[p + 1][c] != null) {
            return dp[p + 1][c];
        }

        Pair skip = dfs(p, c + 1, n, arr, dp);
        int len = skip.len, cnt = skip.cnt;
        
        if (p == -1 || arr[p] < arr[c]) {
            Pair nxt = dfs(c, c + 1, n, arr, dp);
            int len2 = nxt.len + 1;
            int cnt2 = nxt.cnt;
            
            if (len2 > len) {
                len = len2;
                cnt = cnt2;
            } else if (len2 == len) {
                cnt += cnt2;
            }
        }
        
        return dp[p + 1][c] = new Pair(len, cnt);
    }
}

class Pair {

    int len, cnt;

    Pair (int len, int cnt) {
        this.len = len;
        this.cnt = cnt;
    }

}
