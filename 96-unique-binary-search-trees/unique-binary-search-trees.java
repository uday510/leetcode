class Solution {
    public int numTrees(int n) {
        return dfs(n);
    }
     private int dfs(int i) {
        if (i <= 1) return 1;

        int curr = 0;
        for (int j = 1; j <= i; ++j) {
            int left = dfs(j - 1);
            int right = dfs(i - j);
            curr += (left * right);
        }

        return curr;
    }
}