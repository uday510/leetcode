class Solution {
    String[][] matrix;
    boolean[] cols;
    boolean[] dia45;
    boolean[] dia135;
    int ans;
    public int totalNQueens(int n) {
        intialize(n);

        dfs(0, n);

        return ans;
    }
    private void dfs(int row, int n) {
        if (row >= n) {
            ++ans;
            return;
        }

        for (int col = 0; col < n; ++col) {

            if (!valid(row, col, n)) {
                continue;
            }

            flip(row, col, n);

            dfs(row + 1, n);

            flip(row, col, n);

        }
    }
    private void flip(int row, int col, int n) {
        cols[col] = !cols[col];
        dia45[row + col] = !dia45[row + col];
        dia135[row - col + n - 1] = !dia135[row - col + n - 1];
    }
    private boolean valid(int row, int col, int n) {
        return (!cols[col] && !dia45[row + col] && !dia135[row - col + n - 1]);
    }
    private void intialize(int n) {
        matrix = new String[n][n];
        cols = new boolean[n];
        dia45 = new boolean[2 * n - 1];
        dia135 = new boolean[2 * n - 1];
        ans = 0;

        for (String[] row : matrix) {
            Arrays.fill(row, ".");
        }
    }
}