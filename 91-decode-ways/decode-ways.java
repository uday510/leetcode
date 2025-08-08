class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        if (s.startsWith("0")) return 0;

        return dfs(0, s);
    }

    private int dfs(int i, String s) {
        if (i >= s.length()) return 1;

        if (s.charAt(i) == '0') return 0;

        if (dp[i] != -1) return dp[i];

        int t1 = 0;
        int t2 = 0;

        if (Integer.parseInt(s.substring(i, i + 1)) <= 26) 
            t1 = dfs(i + 1, s);
        
        if (i + 2 <= s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            t2 = dfs(i + 2, s);
        }
            
        return dp[i] = t1 + t2;
    }
}