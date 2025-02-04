class Solution {

    int rows;
    int cols;
    Integer[][] memo;
    int minimum;

    public int minFallingPathSum(int[][] matrix) {
        intialize(matrix);

        for (int col = 0; col < cols; ++col) {
            minimum = Math.min(minimum, dfs(0, col, matrix));
        }

        return minimum;
    }

    private int dfs(int row, int col, int[][] matrix) {
        if (!valid(col)) {
            return Integer.MAX_VALUE;
        }

        if (row == rows - 1) {
            return matrix[row][col];
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }
            
        int left = dfs(row + 1, col - 1, matrix);
        int middle = dfs(row + 1, col, matrix);
        int right = dfs(row + 1, col + 1, matrix);

        memo[row][col] = Math.min(left, Math.min(middle, right)) + matrix[row][col];

        return memo[row][col];
    }

    private boolean valid(int col) {
        return !(col < 0 || col >= cols);
    }

    private void intialize(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        minimum = Integer.MAX_VALUE;
        memo = new Integer[rows][cols];
    }
}