public class Solution {
    private boolean[] cols;
    private boolean[] dia45;
    private boolean[] dia135;
    private int ans;

    public int totalNQueens(int n) {
        initialize(n);
        dfs(0, n);
        return ans;
    }

    private void dfs(int row, int n) {
        if (row == n) {
            ans++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(row, col, n)) continue;

            toggle(row, col, n);
            dfs(row + 1, n);
            toggle(row, col, n);
        }
    }

    private void toggle(int row, int col, int n) {
        cols[col] = !cols[col];
        dia45[row + col] = !dia45[row + col];
        dia135[row - col + n - 1] = !dia135[row - col + n - 1];
    }

    private boolean isValid(int row, int col, int n) {
        return !cols[col] && !dia45[row + col] && !dia135[row - col + n - 1];
    }

    private void initialize(int n) {
        cols = new boolean[n];
        dia45 = new boolean[2 * n - 1];
        dia135 = new boolean[2 * n - 1];
        ans = 0;
    }
}