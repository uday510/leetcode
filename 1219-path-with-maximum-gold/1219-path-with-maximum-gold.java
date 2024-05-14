class Solution {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    int maxGold = 0;
    boolean[][] vis;
    public int getMaximumGold(int[][] grid) {
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0) continue;
                vis = new boolean[grid.length][grid[0].length];
                maxGold = Math.max(maxGold, dfs(i, j, grid));
            }
        }
        
        return maxGold;
    }
    public int dfs(int i, int j, int[][] grid) {
        
        int currGold = 0;
        
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            
            if (nextI < 0 || nextI >= grid.length || 
                nextJ < 0 || nextJ >= grid[i].length ||
                vis[nextI][nextJ] || grid[nextI][nextJ] == 0) {
                continue;
            }
            
            currGold = Math.max(currGold, dfs(nextI, nextJ, grid));            
        }      
        vis[i][j] = false;
        return currGold + grid[i][j];
    }
}