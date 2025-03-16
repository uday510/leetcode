class Solution {
    int[][] dirs = {{0, 1},{1, 0}, {-1, 0}, {0, -1}};
    int[][] dp;
    int numRows;
    int numCols;
    public int longestIncreasingPath(int[][] matrix) {
        intialize(matrix);
        int longest = 1;
        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                longest = Math.max(longest, dfs(row, col, matrix));
            }
        }
        return longest;
    }
    private int dfs(int row, int col, int[][] matrix) {
        if (dp[row][col] != -1) return dp[row][col];

        int curr = 0;
        for (int[] dir : dirs) {
            int R  = dir[0] + row;
            int C = dir[1] + col;

            if (R < 0 || R >= numRows || C < 0 || C >= numCols ||
                matrix[R][C] <= matrix[row][col]) {
                continue;
            }

            curr = Math.max(curr, dfs(R, C, matrix));
        }

        return dp[row][col] = curr + 1;
    }
    private void intialize(int[][] matrix) {
        numRows = matrix.length;
        numCols = matrix[0].length;
        dp = new int[numRows][numCols];
        for (int[] row : dp) Arrays.fill(row, -1);
    }
}