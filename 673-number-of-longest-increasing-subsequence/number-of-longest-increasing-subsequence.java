class Pair {
    int len;
    int cnt;

    Pair(int len, int cnt) { this.len = len; this.cnt = cnt; }
}

class Solution {

    Pair[][] dp;
    int n;
    int[] nums;

    public int findNumberOfLIS(int[] nums) {
        n = nums.length;
        this.nums = nums;
        dp = new Pair[n + 1][n];

        return dfs(-1, 0).cnt;
    }

    private Pair dfs(int i, int j) {
        if (j >= n) return new Pair(0, 1);

        if (dp[i + 1][j] != null) return dp[i + 1][j];

        Pair skip = dfs(i, j + 1);
        int len = skip.len;
        int cnt = skip.cnt;

        if (i == -1 || nums[i] < nums[j]) {

            Pair take = dfs(j, j + 1);
            int tLen = 1 + take.len;
            int tCnt = take.cnt;
            
           if (tLen > len) {
                len = tLen;
                cnt = tCnt;
           } else if (tLen == len) cnt += tCnt;
        }
        
        return dp[i + 1][j] = new Pair(len, cnt);
    }

}