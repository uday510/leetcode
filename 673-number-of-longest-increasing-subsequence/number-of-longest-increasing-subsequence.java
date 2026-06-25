class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        Pair[][] dp = new Pair[n + 1][n];

        return dfs(-1, 0, nums.length, nums, dp).cnt;
    }

    private Pair dfs(int p, int c, int n, int[] arr, Pair[][] dp) {
        if (p >= n || c >= n) return new Pair(0, 1);

        if (dp[p + 1][c] != null) return dp[p + 1][c];

        Pair s = dfs(p, c + 1, n, arr, dp);
        int len1 = s.len, cnt1 = s.cnt;
        int len = len1, cnt = cnt1;

        if (p == -1 || arr[p] < arr[c]) {

            Pair nxt = dfs(c, c + 1, n, arr, dp);
            int len2 = 1 + nxt.len;
            int cnt2 = nxt.cnt;

            if (len2 > len1) {
                len = len2;
                cnt = cnt2;
            } else if (len2 == len1) {
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