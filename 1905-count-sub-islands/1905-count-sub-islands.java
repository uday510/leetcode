class Solution {
    private static int m;
    private static int n;
    public int countSubIslands(int[][] g1, int[][] g2) {
        int islands = 0;
        m = g1.length;
        n = g1[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g2[i][j] == 1 && dfs(g1, g2, i, j)) {
                    islands++;
                }
            }
        }
        return islands;
    }
    private boolean dfs(int[][] g1, int[][] g2, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || g2[i][j] == 0) {
            return true;
        }
        g2[i][j] = 0;
        boolean res = g1[i][j] != 0;
        
        res &= dfs(g1, g2, i + 1, j);
        res &= dfs(g1, g2, i - 1, j);
        res &= dfs(g1, g2, i, j + 1);
        res &= dfs(g1, g2, i, j - 1);
        return res;
    }
}