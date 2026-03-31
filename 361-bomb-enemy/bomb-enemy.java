class Solution {
       public int maxKilledEnemies(char[][] grid) {
       int mx = 0;
       int n = grid.length, m = grid[0].length;

       for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               if (grid[i][j] == '0') {
                   mx = Math.max(mx, dfs(i, j, n, m, grid));
               }
           }
       }

       return mx;
    }

    private int dfs(int x, int y, int n, int m, char[][] grid) {
        int cur = 0;

        for (int y1 = y - 1; y1 > -1; --y1) {
            if (grid[x][y1] == 'W') 
                break;
            else if (grid[x][y1] == 'E')
                cur++;
                
        }
        
        for (int y1 = y + 1; y1 < m; y1++) {
            if (grid[x][y1] == 'W')
                break;
            else if (grid[x][y1] == 'E')
                cur++;
        }
        
        for (int x1 = x + 1; x1 < n; x1++) {
            if (grid[x1][y] == 'W')
                break;
            else if (grid[x1][y] == 'E')
                cur++;
        }
        
        for (int x1 = x - 1; x1 > -1; x1--) {
            if (grid[x1][y] == 'W')
                break;
            else if (grid[x1][y] == 'E')
                cur++;
        }
        
        
        return cur;
    }
}