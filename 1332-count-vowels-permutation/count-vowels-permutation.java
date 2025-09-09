class Solution {
    static Map<Character, char[]> map = new HashMap<>();
    int MOD = (int) 1e9 + 7;
    static {
        map.put('#', new char[]{'a', 'e', 'i', 'o', 'u'});
        map.put('a', new char[]{'e'});
        map.put('e', new char[]{'a', 'i'});
        map.put('i', new char[]{'a', 'e', 'o', 'u'});
        map.put('o', new char[]{'i', 'u'});
        map.put('u', new char[]{'a'});
    }
    int n;
    int[][] dp;
    public int countVowelPermutation(int n) {
        this.n = n;
        dp = new int[n][26];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, '#');
    }
    private int dfs(int i, char ch) {
        if (i >= n) return 1;

        if (ch != '#' && dp[i][ch - 'a'] != -1) return dp[i][ch - 'a'];

        int cur = 0;

        for (char nxt : map.get(ch)) {
            cur = (cur + dfs(i + 1, nxt)) % MOD;    
        }

        if (ch != '#') dp[i][ch - 'a'] = cur;
        
        return cur;
    }
}