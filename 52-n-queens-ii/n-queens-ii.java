class Solution {
    boolean[] cols;
    boolean[] dia45;
    boolean[] dia135;
    String[][] matrix;
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

            matrix[row][col] = "Q";

            cols[col] = true;
            dia45[row + col] = true;
            dia135[row - col + n - 1] = true;

            dfs(row + 1, n);

           matrix[row][col] = ".";

            cols[col] = false;
            dia45[row + col] = false;
            dia135[row - col + n - 1] = false;
        }
    }
    private boolean valid(int row, int col, int n) {
        return (!cols[col] && !dia45[row + col] && !dia135[row - col + n - 1]);
    }
    private void intialize(int n) {
        cols = new boolean[n];
        dia45 = new boolean[2 * n - 1];
        dia135 = new boolean[2 * n - 1];
        matrix = new String[n][n];
        ans = 0;

        for (String[] row : matrix) {
            Arrays.fill(row, ".");
        }
    }
}