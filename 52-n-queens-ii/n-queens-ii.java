public class Solution {
    private boolean[] cols;
    private boolean[] dia45;
    private boolean[] dia135;
    private int ans;
    private int n;

    public int totalNQueens(int n) {
        initialize(n);
        dfs(0);
        return ans;
    }

    private void dfs(int row) {
        if (row == n) {
            ans++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(row, col)) continue;

            toggle(row, col);
            dfs(row + 1);
            toggle(row, col);
        }
    }

    private void toggle(int row, int col) {
        cols[col] = !cols[col];
        dia45[row + col] = !dia45[row + col];
        dia135[row - col + n - 1] = !dia135[row - col + n - 1];
    }

    private boolean isValid(int row, int col) {
        return !cols[col] && !dia45[row + col] && !dia135[row - col + n - 1];
    }

    private void initialize(int n) {
        cols = new boolean[n];
        dia45 = new boolean[2 * n - 1];
        dia135 = new boolean[2 * n - 1];
        ans = 0;
        this.n = n;
    }
}