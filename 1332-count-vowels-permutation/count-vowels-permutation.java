class Solution {

    Map<Character, char[]> map;
    int MOD;
    int n;
    int[][] dp;

    public int countVowelPermutation(int n) {
        map = new HashMap<>();
        MOD = (int) 1e9 + 7;
        this.n = n;
        dp = new int[26][n + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        map.put('#', new char[]{'a', 'e', 'i', 'o', 'u'});
        map.put('a', new char[]{'e'});
        map.put('e', new char[]{'a', 'i'});
        map.put('i', new char[]{'a', 'e', 'o', 'u'});
        map.put('o', new char[]{'i', 'u'});
        map.put('u', new char[]{'a'});

        return dfs('#', 0);
    }

    private int dfs(char ch, int i) {
        if (i == n) return 1;

        int curr = 0;

        if (ch != '#' && dp[ch - 'a'][i] != -1) {
            return dp[ch - 'a'][i];
        }
        
        for (char next : map.get(ch)) {
            curr = (curr + dfs(next, i + 1)) % MOD;
        }

        if (ch != '#') dp[ch - 'a'][i] = curr;

        return curr;
    }

}