class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for (int i = 0; i <= n - 3; ++i) {
            for (int j = 0; j <= m - 3; ++j) {
                if (isMagic(i, j, grid)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isMagic(int i, int j, int[][] grid) {
        if (grid[i + 1][j + 1] != 5) return false;

        boolean[] seen = new boolean[10];
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                int val = grid[i + x][j + y];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        return (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] == 15 &&
                grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] == 15 &&
                grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] == 15 &&
                grid[i][j] + grid[i + 1][j] + grid[i + 2][j] == 15 &&
                grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] == 15 &&
                grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] == 15 &&
                grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] == 15 &&
                grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] == 15);
    }
}
