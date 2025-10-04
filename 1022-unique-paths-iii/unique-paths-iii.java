class Solution {
    
    int[][] grid;
    int res;
    int m, n;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        res = 0;
        m = grid.length; n = grid[0].length;
        int zeroes = 0;

        int x = -1, y = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i; y = j;
                } else if (grid[i][j] == 0) {
                    zeroes++;
                }
            }
        }

        dfs(x, y, zeroes + 1);
        return res;
    }

    private void dfs(int x, int y,  int zeroes) {
        if (grid[x][y] == 2) {
            res += zeroes == 0 ? 1 : 0;
            return;
        }

        grid[x][y] = -1;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (Math.abs(dx) + Math.abs(dy) != 1) continue;

                int nx = dx + x, ny = dy + y;

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != -1) {
                    dfs(nx, ny, zeroes - 1);
                }
            }
        }

        grid[x][y] = 0;
    }
}