class Solution {
    int m;
    int n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int islands = 0;
        m = grid1.length;
        n = grid1[0].length;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid2[i][j] == 1 && dfs(i,j, grid1, grid2)) {
                    ++islands;
                }
            }
        }
        return islands;
    }
    private boolean dfs(int i, int j, int[][] g1, int[][] g2) {
        if (valid(i,j, g2))
            return true;
        
        g2[i][j] = 0;
        boolean isSubIsland = g1[i][j] == 1;
        
        isSubIsland &= dfs(i + 1, j, g1, g2);
        isSubIsland &= dfs(i - 1, j, g1, g2);
        isSubIsland &= dfs(i, j + 1, g1, g2);
        isSubIsland &= dfs(i, j - 1, g1, g2);
        
        return isSubIsland;
    }
    public boolean valid(int i, int j, int[][] g2) {
        return (i < 0 || i >= m || j < 0 || j >= n || g2[i][j] == 0);
    }
}